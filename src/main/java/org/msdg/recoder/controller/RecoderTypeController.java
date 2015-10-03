package org.msdg.recoder.controller;

import org.msdg.framework.controller.BaseController;
import org.msdg.recoder.model.Recoder;
import org.msdg.recoder.model.RecoderTag;
import org.msdg.recoder.model.RecoderType;
import org.msdg.recoder.model.User;
import org.msdg.recoder.service.RecoderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RecoderType add(HttpServletRequest request, @ModelAttribute RecoderType recoderType) {
        User user = super.getSessionUser(request);
        return recoderTypeService.add(recoderType, user);
    }
}
