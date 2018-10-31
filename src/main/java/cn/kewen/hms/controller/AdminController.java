package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.Admin;
import cn.kewen.hms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.File;
import java.util.List;

//import org.junit.runner.Request;

//import org.junit.runner.Request;

@Controller
//@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("findAdmins")
    public ModelAndView findAdmins(ModelAndView mav) throws Exception {
        List<Admin> adminlist = adminService.findAdmins();
        mav.addObject("adminlist", adminlist);
        mav.setViewName("admin-list");
        return mav;
    }

    @RequestMapping("adminlogin")
    public ModelAndView adminlogin(HttpServletRequest request, ModelAndView mav, Admin admin,
                                   HttpSession session) throws Exception {
        String pwd = adminService.login(admin.getA_id());
        if (null == pwd) {
            request.setAttribute("idErr", "用户名不存在");
            mav.setViewName("login");
        } else {
            if (admin.getA_pwd().equals(pwd)) {
                session.setAttribute("a_id", admin.getA_id());
                mav.setViewName("admin");
            } else {
                request.setAttribute("pwdErr", "密码错误,请重新登录");
                mav.setViewName("login");
            }
        }
        return mav;
    }

    @RequestMapping("findAdminById")
    public ModelAndView findAdminById(Integer a_id, HttpServletRequest request,
                                      HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Admin> admin = adminService.findAdminById(a_id);
        if (admin != null) {
            mav.addObject("adminlist", admin);
            mav.setViewName("admin-list");
        } else {
            mav.setViewName("admin-list");
        }
        return mav;
    }

    @RequestMapping(value = "addAdmin", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addAdmin(Admin admin, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        String a_id = request.getParameter("a_id");
        String a_pwd = request.getParameter("a_pwd");
        String a_name = request.getParameter("a_name");
        admin.setA_id(Integer.parseInt(a_id));
        admin.setA_pwd(a_pwd);
        admin.setA_name(a_name);
        int i = adminService.addAdmin(admin);
        //添加成功，跳转到其他页面
        if (i > 0) {
            mav.addObject("admin", admin);
            mav.setViewName("admin-list");
        } else {
            mav.addObject("admin", admin);
            mav.setViewName("index");
        }
        return mav;
    }

    @RequestMapping("deleteAdmin")
    public ModelAndView deleteAdmin(int a_id) throws Exception {
        System.out.println("a_id" + a_id);
        ModelAndView mav = new ModelAndView();
        int i = adminService.deleteAdmin(a_id);
        if (i > 0) {
            mav.setViewName("index");
        } else {
            mav.setViewName("index");
        }
        return mav;
    }

    @RequestMapping("showAdminById")
    public ModelAndView showAdminById(Integer a_id, HttpServletRequest request,
                                      HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Admin> adminlist = adminService.findAdminById(a_id);
        Admin admin = adminlist.get(0);
        if (admin != null) {
            mav.addObject("admin", admin);
            mav.setViewName("admin-update");
        } else {
            mav.setViewName("admin-list");
        }
        return mav;
    }

    @RequestMapping("updateAdmin")
    public String updateAdmin(Admin admin) throws Exception {
        boolean i = adminService.updateAdmin(admin);
        if (i) {
            JOptionPane.showMessageDialog(null, "修改成功！");
            return "redirect:/findAdmins.action";
        }
        return "student";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(description);
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，不存在则创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + filename));
            return "upload";
        } else {
            return "error";
        }
    }
//	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
//	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException{
//		
//		if(!file.isEmpty()){
//			//log.debug("Process file: {}", file.getOriginalFilename());
//			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\imooc\\", System.currentTimeMillis()+ file.getOriginalFilename()));
//		}
//		return "ok";
//	}
}
