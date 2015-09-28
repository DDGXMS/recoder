package org.msdg.framework.controller;

import org.msdg.framework.Constants;
import org.msdg.framework.controller.param.Result;
import org.msdg.recoder.exception.UserException;
import org.msdg.recoder.exception.UserNotFoundException;
import org.msdg.recoder.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 控制器基类
 */
public abstract class BaseController {

    /**
     * 从session中取登录信息
     */
    public User getSesionUser(HttpSession session) {
        return (User) session.getAttribute(Constants.SESSION_USER);
    }

    /**
     * 判断是不是IE浏览器
     */
    protected boolean isIE(HttpServletRequest request) {
        String agent = request.getHeader("user-agent");
        if (agent.contains("MSIE")) {
            return true;
        }

        return false;
    }

    /**
     * 获取请求的参数map
     */
    public Map<String, Object> getParamMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        Map<String, String[]> keymap = request.getParameterMap();
        Set<String> set = keymap.keySet();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            map.put(key, request.getParameter(key));
        }
        return map;
    }

    public Result ok() {
        return ok("");
    }

    public static Result ok(String message) {
        return new Result(Result.STATUS.OK, message);
    }

    public static Result fail(String message) {
        return new Result(Result.STATUS.FAIL, message);
    }

    /**
     * 获取用户信息异常
     */
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result userNotFoundException(UserNotFoundException ex) {
        return fail(ex.getMessage());
    }

    /**
     * 用户异常
     */
    @ResponseBody
    @ExceptionHandler(UserException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result userException(UserException ex) {
        return fail(ex.getMessage());
    }
}

