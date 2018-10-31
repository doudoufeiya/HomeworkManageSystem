package cn.kewen.hms.controller;


import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.pojo.Work;
import cn.kewen.hms.service.StudentService;
import cn.kewen.hms.service.TeacherService;
import cn.kewen.hms.service.WorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WorkController {

    private Logger logger = Logger.getLogger(WorkController.class);

    @Autowired
    private WorkService workService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("findWorks")
    public ModelAndView findWorks(ModelAndView mav, PageParams params) throws Exception {
        PageData<Work> works = workService.findWorks(params);
        logger.info("works:" + works);
        mav.addObject("works", works);
        mav.setViewName("jsp/work/work-list");
        return mav;
    }

    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addWorkPage")
    public ModelAndView addWorkPage(ModelAndView mav) throws Exception {
        PageParams params = new PageParams(1, 1000L);
        PageData<Student> students = studentService.findStudentsNoClass(params);
//        PageData<Student> teachers = teacherService.findTeachers(params);
        mav.addObject("students", students.getData());
        mav.setViewName("jsp/work/work-add");
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
    @RequestMapping("deleteWork")
    public ModelAndView deleteWork(ModelAndView mav, Integer s_id) throws Exception {
        if (s_id != null) {
            workService.deleteWork(s_id);
        }
        PageData<Work> works = workService.findWorks(null);
        logger.info("works:" + works);
        mav.addObject("works", works);
        mav.setViewName("jsp/work/work-list");
        return mav;
    }


    @RequestMapping("findWorkByName")
    public ModelAndView findWorkByName(String s_name, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Work> works = workService.findWorkByName(s_name);
        if (works != null) {
            mav.addObject("works", works);
            mav.setViewName("jsp/work/work-list");
        }
        return mav;
    }

    /**
     * 添加学生
     *
     * @param class1
     * @return
     * @throws Exception
     */
    @RequestMapping("addWork")
    public void addClass(Work work) throws Exception {
        workService.addWork(work);
//        studentService.updateStudentClass(class1.getStudents(), class1.getC_id());
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
     * @param class1
     * @return
     * @throws Exception
     */
    @RequestMapping("updateWork")
    public String updateWork(Work work) throws Exception {
        boolean i = workService.updateWork(work);
        if (i) {
            return "redirect:/student/findStudents";
        }
        return "ok";
    }


}
