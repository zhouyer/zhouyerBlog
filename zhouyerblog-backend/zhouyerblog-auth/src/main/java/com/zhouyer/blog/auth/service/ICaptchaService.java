package com.zhouyer.blog.auth.service;

import java.awt.image.BufferedImage;

/**
 * 验证码服务接口
 *
 * @author zhouyao
 * @version 1.0
 * @date 2021/1/10 6:00 下午
 */
public interface ICaptchaService {
    /**
     * 生成验证码
     *
     * @param uuid uuid
     * @return java.awt.image.BufferedImage
     * @author zhouyao
     * @date 2021/1/10 6:16 下午
     */
    BufferedImage createCaptcha(String uuid);

    /**
     * 验证验证码
     *
     * @param uuid 唯一标示符，用于从redis从获取验证码
     * @param code 验证码
     * @return boolean
     * @author zhouyao
     * @date 2021/1/10 6:19 下午
     */
    boolean verifyCaptcha(String uuid, String code);
}
