package org.msdg.framework.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.msdg.framework.Constants;
import org.msdg.recoder.model.User;
import org.msdg.recoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(LoginInterceptor.class);

    private static final long over = 6*60*60*1000;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Token token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = TokenMap.me().getToken(cookie.getValue());
                break;
            }
        }

        if (null != token && System.currentTimeMillis() - token.getTime() < over) {
            User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
            if (null == user) {
                user = userService.getUser(token.getUserId());
                request.getSession(false).setAttribute(Constants.SESSION_USER, user);
            }

            token.setTime(System.currentTimeMillis());
            TokenMap.me().putToken(token);
            return true;
        }

        response.sendRedirect("/user");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
