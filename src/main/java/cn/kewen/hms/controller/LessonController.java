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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public ModelAndView addLessontPage(ModelAndView mav, Integer l_id) throws Exception {
        PageParams params = new PageParams(1, 1000L);
        PageData<Teacher> teachers = teacherService.findTeachersNoLesson(params);

        /**
         * 如果l_id 为空，那么查出来的是所有的学生，如果不为空，查出来的是没有选择的学生
         */
        PageData<Student> students = studentService.findStudentsNoLesson(params, l_id);
        //查找本课程的学生
        List<Student> selectStudents = studentService.findselectStudents(l_id);
        mav.addObject("teachers", teachers.getData());
        mav.addObject("students", students.getData());
        mav.addObject("selectStudents", selectStudents);
        mav.addObject("lesson", lessonService.findLessonById(l_id));
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
    @RequestMapping(value = "addLesson")
    public void addLesson(Lesson lesson) throws Exception {
        if (lesson.getL_id() != null) {
            lessonService.updateLesson(lesson);
            lessonService.deleteTeacher(lesson.getL_id());
            lessonService.deleteScLesson(lesson.getL_id());
        } else {
            lessonService.addLesson(lesson);
        }
        teacherService.updateTeacher(lesson.getT_id(), lesson.getL_id());
        for (Integer student : lesson.getStudents()) {
            ScLesson scLesson = new ScLesson();
            scLesson.setL_id(lesson.getL_id());
            scLesson.setS_id(student);
            scLessonService.addScLesson(scLesson);
        }
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
