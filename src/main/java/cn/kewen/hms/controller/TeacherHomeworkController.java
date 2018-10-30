package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.TeacherHomework;
import cn.kewen.hms.service.TeacherHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeacherHomeworkController {
    @Autowired
    TeacherHomeworkService teacherHomeworkService;

    @RequestMapping("findTeacherHomework")
    public ModelAndView findTeacherHomework(ModelAndView mav) throws Exception {
        List<TeacherHomework> homeworks = teacherHomeworkService.findTeacherHomework();
        mav.addObject("studenthomeworks", homeworks);
        mav.setViewName("studenthomework-list");
        return mav;
    }
}
