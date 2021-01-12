package com.zhouyer.blog.core.constants;

/**
 * Redis Key 相关的常量
 *
 * @author zhouyao
 * @version 1.0
 * @date 2021/1/10 9:22 下午
 */
public final class RedisKeyConstants {

    /**
     * redis 中的key：验证码
     */
    public static final String REDIS_KEY_CAPTCHA = "admin:captcha:";

    /**
     * redis 中的key：用户token
     */
    public static final String REDIS_KEY_USER_TOKEN = "admin:user:token:";
}
