package com.xdht.disease.common.authorization.manager;


import com.xdht.disease.common.model.TokenModel;
import com.xdht.disease.common.model.User;

/**
 * 对Token进行操作的接口
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @return 生成的token
     */
    TokenModel createToken(User user);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    boolean checkToken(TokenModel model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    TokenModel getToken(String authentication);

    /**
     * 清除token
     * @param user 登录用户的
     */
    boolean deleteToken(User user);

}
