package com.zhouyer.blog.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis相关操作的工具类
 *
 * @author zhouyao
 * @version 1.0
 * @date 2021/1/10 8:52 下午
 */
@Component
public class RedisUtil implements ApplicationContextAware {
    /**
     * RedisTemplate
     */
    private static RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RedisUtil.redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
    }

    /**
     * 给key设置过期时间
     *
     * @param key     redis中的键
     * @param timeout 过期时间
     * @param unit    过期时间的单位
     * @return boolean
     * @author zhouyao
     * @date 2021/1/10 9:07 下午
     */
    public static boolean expire(final String key, final long timeout, final TimeUnit unit) {
        Boolean result = redisTemplate.expire(key, timeout, unit);
        return result != null && result;
    }

    /**
     * 设置过期时间
     *
     * @param key     redis中的键
     * @param timeout 过期时间（秒）
     * @return boolean
     * @author zhouyao
     * @date 2021/1/10 9:10 下午
     */
    public static boolean expire(final String key, final long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 在redis上存储普通对象，即设置值
     *
     * @param key     redis中的键
     * @param val     redis中的值
     * @param timeout 过期时间（秒）
     * @return void
     * @author zhouyao
     * @date 2021/1/10 9:15 下午
     */
    public static void set(final String key, final Object val, final long timeout) {
        redisTemplate.opsForValue().set(key, val, timeout, TimeUnit.SECONDS);
    }

    /**
     * 根据key删除对应的值
     *
     * @param key 键
     * @return boolean
     * @author zhouyao
     * @date 2021/1/10 9:17 下午
     */
    public static boolean delete(final String key) {
        Boolean result = redisTemplate.delete(key);
        return result != null && result;
    }
}
