package cn.kewen.hms.controller;


import cn.kewen.hms.pojo.Class;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.ClassService;
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
public class ClassController {

    private Logger logger = Logger.getLogger(ClassController.class);

    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("findClasss")
    public ModelAndView findClasss(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String c_name = request.getParameter("c_name");
        PageData<Class> classes = classService.findClasss(params, c_name);
        logger.info("classes:" + classes);
        mav.addObject("classes", classes);
        mav.setViewName("jsp/class/class-list");
        return mav;
    }

    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addClassPage")
    public ModelAndView addClassPage(ModelAndView mav) throws Exception {
        PageParams params = new PageParams(1, 1000L);
        PageData<Student> students = studentService.findStudentsNoClass(params);
//        PageData<Student> teachers = teacherService.findTeachers(params);
        mav.addObject("students", students.getData());
        mav.setViewName("jsp/class/class-add");
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
    @RequestMapping("deleteClass")
    public ModelAndView deleteClass(ModelAndView mav, Integer s_id) throws Exception {
        if (s_id != null) {
            classService.deleteClass(s_id);
        }
        PageData<Class> classes = classService.findClasss(null, null);
        logger.info("findclasss:" + classes);
        mav.addObject("classes", classes);
        mav.setViewName("jsp/class/class-list");
        return mav;
    }


    @RequestMapping("findClassByName")
    public ModelAndView findClassByName(String s_name, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Class> classes = classService.findClassByName(s_name);
        if (classes != null) {
            mav.addObject("classes", classes);
            mav.setViewName("jsp/class/class-list");
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
    @RequestMapping("addClass")
    public void addClass(Class class1) throws Exception {
        classService.addClass(class1);
        studentService.updateStudentClass(class1.getStudents(), class1.getC_id());
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
    @RequestMapping("updateClass")
    public String updateClass(Class class1) throws Exception {
        boolean i = classService.updateClass(class1);
        if (i) {
            return "redirect:/student/findStudents";
        }
        return "ok";
    }


}
