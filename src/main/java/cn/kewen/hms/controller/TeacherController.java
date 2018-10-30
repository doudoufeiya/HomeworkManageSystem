package cn.kewen.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.pojo.Teacher;
import cn.kewen.hms.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	@RequestMapping("findTeachers")
	public ModelAndView findTeachers(ModelAndView mav) throws Exception{
		List<Teacher> teachers = teacherService.findTeachers();
		mav.addObject("teachers",teachers);
		mav.setViewName("teacher-list");
		return mav;
	}
	@RequestMapping("teacherlogin")
	public ModelAndView studentlogin(HttpServletRequest request,ModelAndView mav,Teacher teacher,
			HttpSession session) throws Exception{
		String pwd = teacherService.login(teacher.getT_id());
		if(null==pwd){
			request.setAttribute("idErr", "用户名不存在"); 
			mav.setViewName("login");
		}else{
			if(teacher.getT_pwd().equals(pwd)){	
				session.setAttribute("t_id", teacher.getT_id());
				mav.setViewName("teacher");
			}else{
				request.setAttribute("pwdErr", "密码错误,请重新登录");
				mav.setViewName("login");
			}
		}
		return mav;
	}
	@RequestMapping("findTeacherByName")
	public ModelAndView findTeacherByName(String s_name,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Teacher> teachers = teacherService.findTeacherByName(s_name);
		if(teachers!=null){
			mav.addObject("teachers",teachers);
			mav.setViewName("teacher-list");
		}
		return mav;
	}
	@RequestMapping("addTeacher")
	public ModelAndView addTeacher(Teacher teacher,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		String t_id = request.getParameter("t_id");
		String t_pwd = request.getParameter("t_pwd");
		String t_name = request.getParameter("t_name");
		teacher.setT_id(Integer.parseInt(t_id));
		teacher.setT_pwd(t_pwd);
		teacher.setT_name(t_name);
		int i = teacherService.addTeacher(teacher);
		//添加成功，跳转到其他页面
		if(i>0){
			mav.addObject("teacher",teacher);
			mav.setViewName("index");
		}else {
			mav.addObject("teacher",teacher);
			mav.setViewName("index");
		}
		return mav;
	}
	@RequestMapping("updateTeacher")
	public String updateTeacher(Teacher teacher) throws Exception{
		boolean i = teacherService.updateTeacher(teacher);
		if(i){
			return "redirect:/Teacher/findTeachers";
		}
		return "ok";	
	}
}