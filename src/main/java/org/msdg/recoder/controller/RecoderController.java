package org.msdg.recoder.controller;

import org.msdg.framework.controller.BaseController;
import org.msdg.recoder.model.Recoder;
import org.msdg.recoder.service.RecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2015/9/13.
 */
@Controller
@RequestMapping("/recoder")
public class RecoderController extends BaseController{

    @Autowired
    private RecoderService recoderService;

    @RequestMapping("/**")
    public String index() {
        return "/recoder";
    }

    @ResponseBody
    @RequestMapping(value = "/{creator}/{pageNo}", method = RequestMethod.GET)
    public List<Recoder> recoderPage(@PathVariable int creator, @PathVariable int pageNo,
                                     @RequestParam(required = false) String keyword,
                                     @RequestParam(required = false) String type,
                                     @RequestParam(required = false) String tags) {
        return recoderService.recoderPage(pageNo, creator, keyword, tags, type);
    }
}
