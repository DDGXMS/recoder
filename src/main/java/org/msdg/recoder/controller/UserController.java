package org.msdg.recoder.controller;

import org.msdg.framework.Constants;
import org.msdg.framework.controller.BaseController;
import org.msdg.framework.interceptor.Token;
import org.msdg.framework.interceptor.TokenMap;
import org.msdg.recoder.model.User;
import org.msdg.recoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by Administrator on 2015/9/12.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/**")
    public String index() {
        return "/login";
    }

    @ResponseBody
    @RequestMapping(value = "/{userName}/login", method = RequestMethod.POST)
    public User login(HttpServletRequest request, @PathVariable String userName, @RequestParam String password) {
        User loginUser = userService.login(userName, password);
        Token token = TokenMap.me().setToken(loginUser.getId());
        loginUser.setToken(token.getToken());
        request.getSession().setAttribute(Constants.SESSION_USER, loginUser);
        return loginUser;
    }
}
