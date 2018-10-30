package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.StudentHomework;
import cn.kewen.hms.service.StudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class StudentHomeworkController {
    @Autowired
    StudentHomeworkService studentHomeworkService;

    @RequestMapping("findStudentHomework")
    public ModelAndView findStudentHomework(ModelAndView mav) throws Exception {
        List<StudentHomework> homeworks = studentHomeworkService.findStudentHomework();
        mav.addObject("homeworks", homeworks);
        mav.setViewName("homework-list");
        return mav;
    }

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {
        StudentHomework homework = new StudentHomework();
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
            homework.setSw_file_name(filename);
            homework.setSw_file_path(path);
            studentHomeworkService.insertStudentHomework(homework);
            JOptionPane.showMessageDialog(null, "上传成功！");
            return "upload";
        } else {
            return "upload";
        }
    }

    /**
     * 文件下载功能
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("filedown")
    public void down(HttpServletRequest request, HttpServletResponse response, String sw_file_path) throws Exception {
        //模拟文件，myfile.txt为需要下载的文件
        String path = request.getSession().getServletContext().getRealPath("upload") + "/myfile.txtf";
        File file = new File(path);
        File[] files = file.listFiles();
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        //假如以中文名下载的话
        String filename = file.getName();
        //转码，免得文件名中文乱码
        path = URLEncoder.encode(path, "UTF-8");
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
}
