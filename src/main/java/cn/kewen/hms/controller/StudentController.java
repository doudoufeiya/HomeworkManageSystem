package cn.kewen.hms.controller;


import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.ClassService;
import cn.kewen.hms.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    private Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @RequestMapping("findStudents")
    public ModelAndView findStudents(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String s_name = request.getParameter("s_name");
        PageData<Student> students = studentService.findStudents(params, s_name);
        logger.info("findStudents:" + students);
        mav.addObject("students", students);
        mav.addObject("s_name", s_name);
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
    public ModelAndView addStudentPage(ModelAndView mav, @RequestParam(required = false) Integer s_id) throws Exception {
        mav.addObject("student", studentService.findStudentById(s_id));
        PageParams params = new PageParams(1, 1000L);
        mav.addObject("classes", classService.findClasss(params, null));
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
                    alertMsg = "还未提交";
                    boolean hasInsert = false;
                    for (int i = 0; i < notCommitWorks.size(); i++) {
                        alertMsg += notCommitWorks.get(i) + "、";
                        hasInsert = true;
                    }
                    if (hasInsert) {
                        alertMsg = alertMsg.substring(0, alertMsg.length() - 1);
                    }
                }
                Student studentInfo = studentService.findStudentById(student.getS_id());
                if (studentInfo.getS_points() < 5 && studentInfo.getS_points() > 0) {
                    mav.addObject("level", "初来乍到");
                } else if (studentInfo.getS_points() < 10 && studentInfo.getS_points() >= 5) {
                    mav.addObject("level", "勤思好问");
                } else if (studentInfo.getS_points() < 15 && studentInfo.getS_points() >= 10) {
                    mav.addObject("level", "融会贯通");
                } else {
                    mav.addObject("level", "学富五车");
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
        if (student.getS_id() == null) {
            studentService.addStudent(student);
        } else {
            studentService.updateStudent(student);
        }
    }

    @RequestMapping("editStudentInfo")
    public void editStudentInfo(Student student, HttpSession session, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/upload");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，不存在则创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + filename));
            student.setS_photo("http://localhost:8080/filedown?fileName=" + URLEncoder.encode(filename));
        }
        student.setS_id(Integer.parseInt(session.getAttribute("s_id").toString()));
        studentService.updateStudent(student);
    }

    /**
     * 添加学生
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("updageStudentMyInfoPage")
    public ModelAndView updageStudentMyInfoPage(ModelAndView mav, HttpSession session) throws Exception {

        Object t_id = session.getAttribute("s_id");
        if (t_id == null) {
            mav.setViewName("login");
            return mav;
        }
        mav.setViewName("jsp/student/myinfo");
        mav.addObject("studentInfo", studentService.findStudentInfoPwdById(Integer.parseInt(t_id.toString())));
        return mav;
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

        Iterator<Map.Entry<String, String[]>> iterator = request.getParameterMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();
            studentService.deleteStudent(Integer.parseInt(entry.getValue()[0]));

        }
        PageData<Student> students = studentService.findStudents(null, null);
        logger.info("findStudents:" + students);
        mav.addObject("students", students);
        mav.setViewName("student-list");
        return mav;
    }

}
