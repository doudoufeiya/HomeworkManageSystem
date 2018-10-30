package cn.kewen.hms.service;

import java.util.List;

import cn.kewen.hms.pojo.Admin;
import cn.kewen.hms.pojo.Student;

public interface StudentService {
	/**
	 * 查询所有学生信息
	 * @param managers
	 * @return
	 * @throws Exception
	 */
	public List<Student> findStudents() throws Exception;
	/**
	 * 登录，根据用户id和密码查找
	 * @param managers
	 * @return
	 * @throws Exception
	 */
	public String login(int s_id) throws Exception;
	/**
	 * 根据学生姓名查询信息
	 * @param mid
	 * @return
	 * @throws Exception
	 */
	public List<Student> findStudentByName(String s_name) throws Exception;
	/**
	 * 添加学生信息
	 * @param managers
	 * @return 如果添加成功则返回true，否则返回false
	 * @throws Exception
	 */
	public int addStudent(Student student) throws Exception;
	/**
	 * 修改学生信息
	 * @param managers
	 * @return 如果修改成功则返回一条记录，否则返回0
	 * @throws Exception
	 */
	public boolean updateStudent(Student student) throws Exception;
	/**
	 * 删除学生信息
	 * 
	 */
	public int deleteStudent(int s_id) throws Exception;
}
