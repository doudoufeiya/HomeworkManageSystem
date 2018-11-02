package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Teacher;
import cn.kewen.hms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("findTeachers")
    public ModelAndView findTeachers(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String t_name = request.getParameter("t_name");
        PageData<Teacher> teachers = teacherService.findTeachers(params, t_name);
        mav.addObject("teachers", teachers);
        mav.setViewName("teacher-list");
        return mav;
    }


    /**
     * 删除老师
     *
     * @param mav
     * @param t_id
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteTeacher")
    public ModelAndView deleteTeacher(ModelAndView mav, Integer t_id) throws Exception {
        if (t_id != null) {
            teacherService.deleteTeacher(t_id);

        }
        PageData<Teacher> teachers = teacherService.findTeachers(null, null);
        mav.addObject("teachers", teachers);
        mav.setViewName("teacher-list");
        return mav;
    }

    @RequestMapping("teacherlogin")
    public ModelAndView teacherlogin(HttpServletRequest request, ModelAndView mav, Teacher teacher,
                                     HttpSession session) throws Exception {
        String pwd = teacherService.login(teacher.getT_id());
        if (null == pwd) {
            request.setAttribute("idErr", "用户名不存在");
            mav.setViewName("login");
        } else {
            if (teacher.getT_pwd().equals(pwd)) {
                session.setAttribute("t_id", teacher.getT_id());
                mav.setViewName("teacher");
            } else {
                request.setAttribute("pwdErr", "密码错误,请重新登录");
                mav.setViewName("login");
            }
        }
        return mav;
    }

    /**
     * 跳转到添加老师页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addTeacherPage")
    public ModelAndView addTeacherPage(ModelAndView mav) {
        mav.clear();
        mav.setViewName("teach/teacher-add");
        return mav;
    }


    @RequestMapping("findTeacherByName")
    public ModelAndView findTeacherByName(String s_name, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Teacher> teachers = teacherService.findTeacherByName(s_name);
        if (teachers != null) {
            mav.addObject("teachers", teachers);
            mav.setViewName("teacher-list");
        }
        return mav;
    }

    @RequestMapping("addTeacher")
    public ModelAndView addTeacher(Teacher teacher) throws Exception {
        ModelAndView mav = new ModelAndView();
        teacherService.addTeacher(teacher);
        //添加成功，跳转到其他页面
//        if (i > 0) {
//            mav.addObject("teacher", teacher);
//            mav.setViewName("index");
//        } else {
//            mav.addObject("teacher", teacher);
//            mav.setViewName("index");
//        }
        return mav;
    }

    @RequestMapping("updateTeacher")
    public String updateTeacher(Teacher teacher) throws Exception {
        boolean i = teacherService.updateTeacher(teacher);
        if (i) {
            return "redirect:/Teacher/findTeachers";
        }
        return "ok";
    }
}
