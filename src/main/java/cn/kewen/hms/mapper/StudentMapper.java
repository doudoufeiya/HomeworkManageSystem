package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Student;

import java.util.List;

public interface StudentMapper {
    /*
     * 显示所有学生信息
     */
    public List<Student> findStudents() throws Exception;

    /*
     * 根据用户名找密码
     */
    public String findPwdById(int s_id) throws Exception;

    /*
     * 根据姓名查找学生信息
     */
    public List<Student> findStudentByName(String s_name) throws Exception;

    /*
     * 修改信息
     */
    public int updateStudent(Student student) throws Exception;

    /*
     * 添加学生信息
     */
    public int addStudent(Student student) throws Exception;

    /*
     * 删除学生信息
     */
    public int deleteStudent(int s_id) throws Exception;
}
