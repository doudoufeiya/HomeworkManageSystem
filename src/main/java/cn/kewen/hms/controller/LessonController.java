package cn.kewen.hms.controller;


import cn.kewen.hms.pojo.*;
import cn.kewen.hms.service.LessonService;
import cn.kewen.hms.service.ScLessonService;
import cn.kewen.hms.service.StudentService;
import cn.kewen.hms.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LessonController {

    private Logger logger = Logger.getLogger(LessonController.class);

    @Autowired
    private LessonService lessonService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ScLessonService scLessonService;

    @RequestMapping("findLessons")
    public ModelAndView findLessons(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {

        String l_name = request.getParameter("l_name");
        PageData<Lesson> lessons = lessonService.findLessons(params, l_name);
        logger.info("lessons:" + lessons);
        mav.addObject("lessons", lessons);
        mav.setViewName("jsp/lesson/lesson-list");
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
        PageParams params = new PageParams(1, 1000L);
        PageData<Teacher> teachers = teacherService.findTeachersNoLesson(params);
        PageData<Student> students = studentService.findStudents(params, null);
        mav.addObject("teachers", teachers.getData());
        mav.addObject("students", students.getData());
        mav.setViewName("jsp/lesson/lesson-add");
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
        PageData<Lesson> lessons = lessonService.findLessons(null, null);
        logger.info("findStudents:" + lessons);
        mav.addObject("lessons", lessons);
        mav.setViewName("jsp/lesson/lesson-list");
        return mav;
    }


    /**
     * 添加学生
     *
     * @param lesson
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addLesson", method = {RequestMethod.POST, RequestMethod.GET})
    public void addLesson(Lesson lesson) throws Exception {
        ModelAndView mav = new ModelAndView();
        lessonService.addLesson(lesson);
        teacherService.updateTeacher(lesson.getT_id(), lesson.getL_id());
        for (Integer student : lesson.getStudents()) {
            ScLesson scLesson = new ScLesson();
            scLesson.setL_id(lesson.getL_id());
            scLesson.setS_id(student);
            scLessonService.addScLesson(scLesson);
        }
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

    /**
     * 删除学生
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("batchDeleteLesson")
    public ModelAndView batchDeleteLesson(ModelAndView mav, HttpServletRequest request) throws Exception {
        request.getParameterMap().forEach((s, strings) -> {
            try {
                lessonService.deleteLesson(Integer.parseInt(strings[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        PageData<Lesson> lessons = lessonService.findLessons(null, null);
        logger.info("lessons:" + lessons);
        mav.addObject("lessons", lessons);
        mav.setViewName("jsp/lesson/lesson-list");
        return mav;
    }

}
