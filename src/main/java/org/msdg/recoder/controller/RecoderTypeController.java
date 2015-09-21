package org.msdg.recoder.controller;

import org.msdg.framework.controller.BaseController;
import org.msdg.recoder.model.RecoderType;
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
@RequestMapping("/type")
public class RecoderTypeController extends BaseController {

    @Autowired
    private RecoderTypeService recoderTypeService;

    @ResponseBody
    @RequestMapping(value = "/{creator}", method = RequestMethod.GET)
    public List<RecoderType> getAllTypes(@PathVariable int creator) {
        return recoderTypeService.allTypes(creator);
    }
}
