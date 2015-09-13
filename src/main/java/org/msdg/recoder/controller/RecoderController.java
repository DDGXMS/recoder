package org.msdg.recoder.controller;

import com.fasterxml.jackson.databind.deser.Deserializers;
import org.msdg.framework.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/9/13.
 */
@Controller
@RequestMapping("/recoder")
public class RecoderController extends BaseController{

    @RequestMapping("/**")
    public String index() {
        return "/recoder";
    }
}
