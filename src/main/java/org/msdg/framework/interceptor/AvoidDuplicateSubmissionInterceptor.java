package org.msdg.framework.interceptor;

import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.msdg.framework.Constants;
import org.msdg.framework.controller.param.Result;
import org.msdg.recoder.model.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * 防止非法提交的拦截器
 */
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LogManager.getLogger(AvoidDuplicateSubmissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = null;
        // session是否有效
        if (request.getSession() != null) {
            // session有效的场合, 取得session中的用户
            user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        }

        if (handler instanceof HandlerMethod) {
            if (user != null) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                // 取得当前方法名
                Method method = handlerMethod.getMethod();

                // 取得方法中AvoidDuplicateSubmission的注释
                AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);
                if (annotation != null) {
                    String tokenName = getTokenName(request, handlerMethod);
                    //如果存在表示前一个请求还没结束
                    if (StringUtils.isNotEmpty((String)request.getSession(false).getAttribute(tokenName))) {
                        // 如果提交无效的场合
                        LOGGER.error("please don't repeat submit,[user:" + user.getUserName()
                                + ", url:" + request.getServletPath() +
                                ",tokenName:" + tokenName + "]");
                        writeResponse(response);
                        return false;
                    }
                    request.getSession(false).setAttribute(tokenName, UUID.randomUUID().toString());
                }
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 取得方法中AvoidDuplicateSubmission的注解
            AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);
            if (annotation != null) {
                String tokenName = getTokenName(request, handlerMethod);
                request.getSession(false).removeAttribute(tokenName);
            }
        }
    }

    private String getTokenName(HttpServletRequest request, HandlerMethod handlerMethod) {
        String className = handlerMethod.getBeanType().getName();
        String classMethod = handlerMethod.getMethod().getName();
        String params = JSON.toJSONString(request.getParameterMap());
        String requestUrl = request.getRequestURI();
        return className + "." + classMethod + "." + requestUrl + "." + params;
    }

    private void writeResponse(HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.write(new Result(Result.STATUS.FAIL).put("type", "DuplicateSubmission").put("message", "数据处理中，请勿重复提交").toJson());
        }
    }

}