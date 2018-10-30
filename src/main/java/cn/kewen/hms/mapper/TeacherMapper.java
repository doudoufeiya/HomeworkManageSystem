package cn.kewen.hms.mapper;

import java.util.List;

import cn.kewen.hms.pojo.Teacher;

public interface TeacherMapper {
	/*
	 * 显示所有信息
	 */
	public List<Teacher> findTeachers() throws Exception;
	/*
	 * 根据用户名找密码
	 */
	public String findPwdById(int t_id) throws Exception;
	/*
	 * 根据姓名查找信息
	 */
	public List<Teacher> findTeacherByName(String t_name) throws Exception;
	/*
	 * 修改信息
	 */
	public int updateTeacher(Teacher teacher) throws Exception;
	/*
	 * 添加信息
	 */
	public int addTeacher(Teacher teacher) throws Exception;
	/*
	 * 删除信息
	 */
	public int deleteTeacher(int t_id) throws Exception;
}
