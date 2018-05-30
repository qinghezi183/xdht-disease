package com.xdht.disease.common.authorization.manager.impl;

import com.alibaba.fastjson.JSON;
import com.xdht.disease.common.authorization.manager.TokenManager;
import com.xdht.disease.common.model.TokenModel;
import com.xdht.disease.common.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by L on 2018/5/30.
 */
@Service("ehcacheTokenManager")
public class EhcacheTokenManager implements TokenManager {

    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    @Override
    public TokenModel createToken(User user) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(user.getId(), user.getId()+"_"+token,user);

        //存储到cache中
        Cache cache = ehCacheCacheManager.getCache("user");
        cache.put("login_" + user.getId(), token);
        cache.put("userInfo_" + user.getId(), JSON.toJSONString(model.getUser()));
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        Cache cache = ehCacheCacheManager.getCache("user");
        String  token = cache.get("login_"+model.getUserId()).toString();
        if (StringUtils.isNotEmpty(token) && token.equals(model.getToken())) {

            String  userJson = cache.get("userInfo_"+model.getUserId()).toString();

            User user = JSON.parseObject(userJson,User.class);
            if(token.equals(model.getToken())) {
                model.setUser(user);
            }else{
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        Long userId = Long.valueOf(param[0]);//用户ID
        String token = param[1];
        return new TokenModel(userId, token,null);
    }

    @Override
    public boolean deleteToken(User user) {
        if(user != null && user.getId() != null){
            Cache cache = ehCacheCacheManager.getCache("user");
            cache.evict("login_" + user.getId());
            cache.evict("userInfo_" + user.getId());
            return true;
        }
        return false;
    }
}
