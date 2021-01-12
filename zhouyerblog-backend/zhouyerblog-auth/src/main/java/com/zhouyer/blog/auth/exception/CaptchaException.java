package com.zhouyer.blog.auth.exception;

/**
 * 操作验证码相关异常
 *
 * @author zhouyao
 * @version 1.0
 * @date 2021/1/10 8:14 下午
 */
public class CaptchaException extends RuntimeException {
    public CaptchaException() {
        super();
    }

    public CaptchaException(String message) {
        super(message);
    }

    public CaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaException(Throwable cause) {
        super(cause);
    }
}
