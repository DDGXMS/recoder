package org.msdg.recoder.controller;

import org.msdg.framework.controller.BaseController;
import org.msdg.recoder.model.RecoderTag;
import org.msdg.recoder.model.RecoderType;
import org.msdg.recoder.service.RecoderTagService;
import org.msdg.recoder.service.RecoderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
