package cn.kewen.hms.controller;


import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
//@RequestMapping("student")
public class StudentController {

    private Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("findStudents")
    public ModelAndView findStudents(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String s_name = request.getParameter("s_name");
        PageData<Student> students = studentService.findStudents(params, s_name);
        logger.info("findStudents:" + students);
        mav.addObject("students", students);
        mav.setViewName("student-list");
        return mav;
    }

    @GetMapping("notCommitWork")
    @ResponseBody
    public List<String> getNotCommitWork(Integer studentId) throws Exception {
        return studentService.getToCommitWorkName(studentId);
    }

    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addStudentPage")
    public ModelAndView addStudentPage(ModelAndView mav) throws Exception {
        mav.setViewName("stu/student-add");
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
    @RequestMapping("deleteStudent")
    public ModelAndView deleteStudent(ModelAndView mav, Integer s_id) throws Exception {
        if (s_id != null) {
            studentService.deleteStudent(s_id);

        }
        PageData<Student> students = studentService.findStudents(null, null);
        logger.info("findStudents:" + students);
        mav.addObject("students", students);
        mav.setViewName("student-list");
        return mav;
    }

    @RequestMapping("studentlogin")
    public ModelAndView studentlogin(HttpServletRequest request, ModelAndView mav, Student student,
                                     HttpSession session) throws Exception {
        String pwd = studentService.login(student.getS_id());

        if (null == pwd) {
            request.setAttribute("idErr", "用户名不存在");
            mav.setViewName("login");
        } else {
            if (student.getS_pwd().equals(pwd)) {
                session.setAttribute("s_id", student.getS_id());
                List<String> notCommitWorks = studentService.getToCommitWorkName(student.getS_id());
                String alertMsg = "";
                if (!CollectionUtils.isEmpty(notCommitWorks)) {
                    alertMsg = "还未提交" + notCommitWorks.stream().reduce((x, y) -> x + "、" + y).orElse("");
                }
                mav.addObject("alertMsg", alertMsg);
                mav.setViewName("student");
            } else {
                request.setAttribute("pwdErr", "密码错误,请重新登录");
                mav.setViewName("login");
            }
        }
        return mav;
    }

    @RequestMapping("findStudentByName")
    public ModelAndView findStudentByName(String s_name, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Student> students = studentService.findStudentByName(s_name);
        if (students != null) {
            mav.addObject("students", students);
            mav.setViewName("student-list");
        }
        return mav;
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     * @throws Exception
     */
    @RequestMapping("addStudent")
    public void addStudent(Student student) throws Exception {
        ModelAndView mav = new ModelAndView();
        studentService.addStudent(student);
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
     * @param student
     * @return
     * @throws Exception
     */
    @RequestMapping("updateStudent")
    public String updateStudent(Student student) throws Exception {
        boolean i = studentService.updateStudent(student);
        if (i) {
            return "redirect:/student/findStudents";
        }
        return "ok";
    }

    /**
     * 文件上传功能
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        return "student";
    }

    /**
     * 文件下载功能
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("down")
    public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("upload") + "/myfile.txt";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename, "UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }

    /**
     * 删除学生
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("batchDeleteStudent")
    public ModelAndView batchDeleteStudent(ModelAndView mav, HttpServletRequest request) throws Exception {
        request.getParameterMap().forEach((s, strings) -> {
            try {
                studentService.deleteStudent(Integer.parseInt(strings[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        PageData<Student> students = studentService.findStudents(null, null);
        logger.info("findStudents:" + students);
        mav.addObject("students", students);
        mav.setViewName("student-list");
        return mav;
    }

}
