package cn.kewen.hms.controller;


import cn.kewen.hms.pojo.Class;
import cn.kewen.hms.pojo.*;
import cn.kewen.hms.service.ClassService;
import cn.kewen.hms.service.StudentService;
import cn.kewen.hms.service.TeacherService;
import cn.kewen.hms.service.WorkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class WorkController {

    private Logger logger = Logger.getLogger(WorkController.class);

    @Autowired
    private WorkService workService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("findWorks")
    public ModelAndView findWorks(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String tw_name = request.getParameter("tw_name");
        PageData<Work> works = workService.findWorks(params, tw_name);
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
    public ModelAndView addWorkPage(ModelAndView mav, HttpSession session) throws Exception {
        PageParams params = new PageParams(1, 1000L);
        PageData<Student> students = studentService.findStudentsNoClass(params);
        PageData<Class> classs = classService.findClasss(params, null);
        mav.addObject("classs", classs.getData());
        mav.setViewName("jsp/work/work-add");
        return mav;
    }

    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("viewWorkPage")
    public ModelAndView viewWorkPage(ModelAndView mav, Integer workId) throws Exception {
        List<String> notCommitStudentNames = studentService.toCommitWorkStudentNames(workId);
        List<String> notReadStudentNames = teacherService.findNotReadWork(workId);
        mav.addObject("notCommitStudentNames", Arrays.asList("222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222"));
        mav.addObject("notReadStudentNames", Arrays.asList("222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222", "222"));
        mav.setViewName("jsp/work/work-detail");
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
        PageData<Work> works = workService.findWorks(null, null);
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
     * @param work
     * @param session
     * @param file
     * @throws Exception
     */
    @RequestMapping(value = "addWork", method = RequestMethod.POST)
    public void addWork(HttpServletRequest request, @RequestParam("uploadfile") MultipartFile file) throws Exception {
        String tw_name = request.getParameter("tw_name");
        String c_id = request.getParameter("c_id");
        String tw_deadLine = request.getParameter("tw_deadLine");
        String fileName = file.getOriginalFilename();
        Object tw_tid = request.getSession().getAttribute("t_id");
        if (tw_name == null || c_id == null || tw_deadLine == null || fileName == null
                || tw_tid == null) {
            return;
        }
        Work work = new Work();
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
            work.setTw_file_path("http://localhost:8080/filedown?fileName=" + URLDecoder.decode(fileName));
        }

        if (null == work.getTw_file_path()) {
            return;
        }
        work.setTw_name(tw_name);
        work.setTw_cid(Integer.parseInt(c_id));
        work.setTw_tid(Integer.parseInt(tw_tid.toString()));
        work.setTw_addTime(new Date());
        work.setTw_deadLine(new SimpleDateFormat("yyyy-MM-dd").parse(tw_deadLine));
        work.setTw_file_name(fileName);
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
     * @param work
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
