package org.msdg.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/9/27.
 */
@Controller
@RequestMapping("/")
public class GlobalController {

    @RequestMapping("/**")
    public String index() {
        return "/recoder";
    }
}
