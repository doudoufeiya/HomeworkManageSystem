package cn.kewen.hms.service;

import java.util.List;

import cn.kewen.hms.pojo.Teacher;

public interface TeacherService {
	/**
	 * 查询所有教师信息
	 * @param managers
	 * @return
	 * @throws Exception
	 */
	public List<Teacher> findTeachers() throws Exception;
	/**
	 * 管理员登录，根据用户id和密码查找
	 * @param managers
	 * @return
	 * @throws Exception
	 */
	public String login(int t_id) throws Exception;
	/**
	 * 根据教师姓名查询信息
	 * @param mid
	 * @return
	 * @throws Exception
	 */
	public List<Teacher> findTeacherByName(String t_name) throws Exception;
	/**
	 * 添加教师信息
	 * @param managers
	 * @return 如果添加成功则返回true，否则返回false
	 * @throws Exception
	 */
	public int addTeacher(Teacher teacher) throws Exception;
	/**
	 * 修改教师信息
	 * @param managers
	 * @return 如果修改成功则返回一条记录，否则返回0。
	 * @throws Exception
	 */
	public boolean updateTeacher(Teacher teacher) throws Exception;
	/**
	 * 删除教师信息
	 * 
	 */
	public int deleteTeacher(int t_id) throws Exception;
}
