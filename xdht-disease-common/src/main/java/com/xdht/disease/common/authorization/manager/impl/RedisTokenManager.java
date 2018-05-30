package com.xdht.disease.common.authorization.manager.impl;

import com.alibaba.fastjson.JSON;
import com.xdht.disease.common.model.User;
import com.xdht.disease.common.authorization.manager.TokenManager;
import com.xdht.disease.common.model.TokenModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lzf
 */
@Service("redisTokenManager")
public class RedisTokenManager implements TokenManager {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public TokenModel createToken(String userId, User user) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, userId+"_"+token,user);

        //存储到redis并设置过期时间
        redisTemplate.opsForValue().set("login_" + userId, token, 8, TimeUnit.HOURS);
        redisTemplate.opsForValue().set("userInfo_" + userId, JSON.toJSONString(model.getUser()));
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String  token = (String) redisTemplate.opsForValue().get("login_"+model.getUserId());
        if (StringUtils.isNotEmpty(token) && token.equals(model.getToken())) {

            String  userJson = (String) redisTemplate.opsForValue().get("userInfo_"+model.getUserId());

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
        String userId = param[0];//用户ID
        String token = param[1];
        return new TokenModel(userId, token,null);
    }

    @Override
    public boolean deleteToken(User user) {
        if(user != null && user.getId() != null){
            redisTemplate.delete("login_" + user.getId());
            return true;
        }
        return false;
    }
}
