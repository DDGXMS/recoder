package org.msdg.recoder.exception;

/**
 * Created by Administrator on 2015/9/12.
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        this("用户尚未注册");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
