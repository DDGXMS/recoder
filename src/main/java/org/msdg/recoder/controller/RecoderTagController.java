package org.msdg.recoder.controller;

import org.msdg.framework.controller.BaseController;
import org.msdg.recoder.model.Recoder;
import org.msdg.recoder.model.RecoderTag;
import org.msdg.recoder.model.User;
import org.msdg.recoder.service.RecoderTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2015/9/22.
 */
@Controller
@RequestMapping("/tag")
public class RecoderTagController extends BaseController {

    @Autowired
    private RecoderTagService recoderTagService;

    @ResponseBody
    @RequestMapping(value = "/{creator}", method = RequestMethod.GET)
    public List<RecoderTag> getAllTags(@PathVariable int creator) {
        return recoderTagService.allTags(creator);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RecoderTag add(HttpServletRequest request, @ModelAttribute RecoderTag recoderTag) {
        User user = super.getSessionUser(request);
        return recoderTagService.add(recoderTag, user);
    }
}
