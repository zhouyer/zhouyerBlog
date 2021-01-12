package com.zhouyer.blog.auth.service.impl;

import com.google.code.kaptcha.Producer;
import com.zhouyer.blog.auth.exception.CaptchaException;
import com.zhouyer.blog.auth.service.ICaptchaService;
import com.zhouyer.blog.core.constants.RedisKeyConstants;
import com.zhouyer.blog.core.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

/**
 * 验证码实现类
 *
 * @author zhouyao
 * @version 1.0
 * @date 2021/1/10 6:21 下午
 */
@Service
public class CaptchaService implements ICaptchaService {
    @Autowired
    private Producer producer;

    // 验证码过期时间为 2分钟
    private static final long EXPIRE_CAPTCHA = 60 * 2;

    @Override
    public BufferedImage createCaptcha(String uuid) {
        if (StringUtils.isEmpty(uuid)) {
            throw new CaptchaException("生成验证码过程中，uuid为空");
        }
        //生成文字验证码
        String text = producer.createText();
        //将该验证码保存到redis中，过期时间为2分钟
        RedisUtil.set(getCaptchaKey(uuid), text, EXPIRE_CAPTCHA);
        //生成图片验证码
        return producer.createImage(text);
    }

    @Override
    public boolean verifyCaptcha(String uuid, String code) {
        return false;
    }

    private String getCaptchaKey(String uuid) {
        return RedisKeyConstants.REDIS_KEY_CAPTCHA + uuid;
    }
}
