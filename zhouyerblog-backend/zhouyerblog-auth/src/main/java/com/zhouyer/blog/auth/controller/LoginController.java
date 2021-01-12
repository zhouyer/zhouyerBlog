package com.zhouyer.blog.auth.controller;

import com.zhouyer.blog.auth.service.ICaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 系统登陆 Controller
 *
 * @author zhouyao
 * @version 1.0
 * @date 2021/1/10 3:17 下午
 */
@RestController
@RequestMapping("api/")
public class LoginController {
    @Autowired
    private ICaptchaService captchaService;

    /**
     * 获取验证码
     *
     * @param response 响应体
     * @param uuid     验证码唯一标示
     * @return java.lang.String
     * @author zhouyao
     * @date 2021/1/10 11:23 下午
     */
    @GetMapping("/v1/captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        BufferedImage image = captchaService.createCaptcha(uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.flush();
    }
}
