package cn.kewen.hms.controller;


import cn.kewen.hms.pojo.Lesson;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.service.LessonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class LessonController {

    private Logger logger = Logger.getLogger(LessonController.class);

    @Autowired
    private LessonService lessonService;

    @RequestMapping("findLessons")
    public ModelAndView findLessons(ModelAndView mav, PageParams params) throws Exception {
        PageData<Lesson> lessons = lessonService.findLessons(params);
        logger.info("lessons:" + lessons);
        mav.addObject("lessons", lessons);
        mav.setViewName("lesson-list");
        return mav;
    }

    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addLessonPage")
    public ModelAndView addLessontPage(ModelAndView mav) throws Exception {
        mav.setViewName("stu/lesson-add");
        return mav;
    }


    /**
     * 删除学生
     *
     * @param mav
     * @param s_id
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteLesson")
    public ModelAndView deleteLesson(ModelAndView mav, Integer s_id) throws Exception {
        if (s_id != null) {
            lessonService.deleteLesson(s_id);

        }
        PageData<Lesson> lessons = lessonService.findLessons(null);
        logger.info("findStudents:" + lessons);
        mav.addObject("lessons", lessons);
        mav.setViewName("lesson-list");
        return mav;
    }



    /**
     * 添加学生
     *
     * @param lesson
     * @return
     * @throws Exception
     */
    @RequestMapping("addLesson")
    public void addLesson(Lesson lesson) throws Exception {
        ModelAndView mav = new ModelAndView();
        lessonService.addLesson(lesson);
//        //添加成功，跳转到其他页面
//        PageData<Student> students = studentService.findStudents(null);
//        logger.info("findStudents:" + students);
//        mav.addObject("students", students);
//        mav.setViewName("student-list");
//        return mav;
    }

    /**
     * 修改学生
     *
     * @param lesson
     * @return
     * @throws Exception
     */
    @RequestMapping("updateLesson")
    public String updateLesson(Lesson lesson) throws Exception {
        boolean i = lessonService.updateLesson(lesson);
        if (i) {
            return "redirect:/student/findStudents";
        }
        return "ok";
    }


}
