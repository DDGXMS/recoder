package org.msdg.recoder.controller;

import org.msdg.framework.controller.BaseController;
import org.msdg.recoder.model.User;
import org.msdg.recoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public User login(@PathVariable String userName, @RequestParam String password) {
        return userService.login(userName, password);
    }
}
