package cn.kewen.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("login")
    public ModelAndView findAdmins(ModelAndView mav) throws Exception {
//        List<Admin> adminlist = adminService.findAdmins();
//        mav.addObject("adminlist", adminlist);
        mav.setViewName("login");
        return mav;
    }

}
