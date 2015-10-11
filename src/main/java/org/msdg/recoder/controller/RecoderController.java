package org.msdg.recoder.controller;

import org.msdg.framework.controller.BaseController;
import org.msdg.recoder.controller.property.LongToDateEditor;
import org.msdg.recoder.model.Recoder;
import org.msdg.recoder.model.User;
import org.msdg.recoder.service.RecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/9/13.
 */
@Controller
@RequestMapping("/recoder")
public class RecoderController extends BaseController{

    @Autowired
    private RecoderService recoderService;

    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        LongToDateEditor editor = new LongToDateEditor();
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping("/**")
    public String index() {
        return "/recoder";
    }

    @ResponseBody
    @RequestMapping(value = "/{creator}/page/{pageNo}", method = RequestMethod.GET)
    public List<Recoder> recoderPage(@PathVariable int creator, @PathVariable int pageNo,
                                     @RequestParam(required = false) String keyword,
                                     @RequestParam(required = false) String recoderType,
                                     @RequestParam(required = false) String tags) {
        return recoderService.recoderPage(pageNo, creator, keyword, tags, recoderType);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Recoder getRecoder(@PathVariable int id) {
        return recoderService.getRecoder(id);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Recoder add(HttpServletRequest request, @ModelAttribute Recoder recoder) {
        User user = super.getSessionUser(request);
        return recoderService.add(recoder, user);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        recoderService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public Recoder update(@ModelAttribute Recoder recoder) {
        recoderService.update(recoder);
        return recoderService.getRecoder(recoder.getId());
    }
}
