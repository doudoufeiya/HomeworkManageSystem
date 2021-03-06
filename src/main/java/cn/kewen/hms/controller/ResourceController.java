package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Resource;
import cn.kewen.hms.service.ResourceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;

@Controller
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    private Logger logger = Logger.getLogger(ResourceController.class);


    @RequestMapping("findResources")
    public ModelAndView findResources(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String r_name = request.getParameter("r_name");
        PageData<Resource> resources = resourceService.findResources(params, r_name);
        logger.info("resources:" + resources);
        mav.addObject("resources", resources);
        mav.addObject("r_name", r_name);
        mav.setViewName("jsp/resource/resource-list");
        return mav;
    }


    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addresourcePage")
    public ModelAndView addStudentPage(ModelAndView mav, @RequestParam(required = false) Integer r_id) throws Exception {
        mav.setViewName("jsp/resource/resource-add");
        mav.addObject("r_id", r_id);
        return mav;
    }

    @RequestMapping("findTeacherResources")
    public ModelAndView findTeacherQuestions(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String r_name = request.getParameter("r_name");
        PageData<Resource> resources = resourceService.findResources(params, r_name);
        logger.info("resources:" + resources);
        mav.addObject("resources", resources);
        mav.setViewName("jsp/resource/resource-teacher");
        return mav;
    }

    @RequestMapping("gotoResourcePage")
    public ModelAndView gotoResourcePage(ModelAndView mav, @RequestParam(required = false) Integer r_id) throws Exception {
        mav.addObject("r_id", r_id);
        mav.addObject("resurce", resourceService.findResourceById(r_id));
        mav.setViewName("jsp/resource/resource-add");
        return mav;
    }

//    @RequestMapping("answerQuestions")
//    public void answerQuestions(ModelAndView mav, Question question, HttpSession session) throws Exception {
//        question.setT_id(Integer.parseInt(session.getAttribute("t_id").toString()));
//        resourceService.answerQuestions(question);
////        logger.info("questions:" + questions);
////        mav.addObject("questions", questions);
////        mav.setViewName("jsp/question/question-teacher");
////        return mav;
//    }


    /**
     * 删除学生
     *
     * @param mav
     * @param s_id
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteResource")
    public ModelAndView deleteResource(ModelAndView mav, Integer s_id) throws Exception {
        if (s_id != null) {
            resourceService.deleteResource(s_id);

        }
        PageData<Resource> resources = resourceService.findResources(null, null);
        logger.info("resources:" + resources);
        mav.addObject("resources", resources);
        mav.setViewName("jsp/resource/resource-list");
        return mav;
    }


//    /**
//     * 添加学生
//     *
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("addResource")
//    public ModelAndView addResource(Resource resource, ModelAndView mav) throws Exception {
//        if (resource.getR_id() == null) {
//            resourceService.addResource(resource);
//        } else {
//            resourceService.editResource(resource);
//        }
//        return mav;
//    }


    /**
     * @param file
     * @throws Exception
     */
    @RequestMapping(value = "addResource")
    public void addResource(HttpServletRequest request, @RequestParam("uploadfile") MultipartFile file) throws Exception {
        String r_name = request.getParameter("r_name");
        Object tId = request.getSession().getAttribute("t_id");
        Object aId = request.getSession().getAttribute("a_id");
        Object r_id = request.getParameter("r_id");
        String fileName = file.getOriginalFilename();
        if (r_name == null || (tId == null && aId == null)) {
            return;
        }
        Resource resource = new Resource();
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
            resource.setR_file_name(filename);
            resource.setR_file_path("http://localhost:8080/HomeworkManageSystem/filedown?fileName=" + URLDecoder.decode(fileName));
        }

        if (null == resource.getR_file_path()) {
            return;
        }
        resource.setR_name(r_name);
        resource.setR_tid(Integer.parseInt(null == tId ? aId.toString() : tId.toString()));

        if (r_id == null || ((String) r_id).equalsIgnoreCase("")) {
            resourceService.addResource(resource);
        } else {
            resource.setR_id(Integer.parseInt(r_id.toString()));
            resourceService.editResource(resource);
        }

//        studentService.updateStudentClass(class1.getStudents(), class1.getC_id());
//        //添加成功，跳转到其他页面
//        PageData<Student> students = studentService.findStudents(null);
//        logger.info("findStudents:" + students);
//        mav.addObject("students", students);
//        mav.setViewName("student-list");
//        return mav;
    }

    /**
     * 删除学生
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("batchDeleteResource")
    public ModelAndView batchDeleteResource(ModelAndView mav, HttpServletRequest request) throws Exception {

        Iterator<Map.Entry<String, String[]>> iterator = request.getParameterMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();
            resourceService.deleteResource(Integer.parseInt(entry.getValue()[0]));
        }
        PageData<Resource> resources = resourceService.findResources(null, null);
        logger.info("resources:" + resources);
        mav.addObject("resources", resources);
        mav.setViewName("jsp/resource/resource-list");
        return mav;
    }

}
