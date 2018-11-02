package cn.kewen.hms.service;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有学生信息
     *
     * @param params
     * @param s_name
     * @return
     * @throws Exception
     */
    PageData<Student> findStudents(PageParams params, String s_name) throws Exception;

    /**
     * 查询没有班级的学生
     *
     * @param params
     * @return
     * @throws Exception
     */
    PageData<Student> findStudentsNoClass(PageParams params) throws Exception;

    List<String> toCommitWorkStudentNames(Integer workId) throws Exception;

    List<String> getToCommitWorkName(Integer studentId) throws Exception;

    /**
     * 登录，根据用户id和密码查找
     *
     * @return
     * @throws Exception
     */
    String login(int s_id) throws Exception;

    /**
     * 根据学生姓名查询信息
     *
     * @return
     * @throws Exception
     */
    List<Student> findStudentByName(String s_name) throws Exception;

    /**
     * 添加学生信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addStudent(Student student) throws Exception;

    /**
     * 修改学生信息
     *
     * @return 如果修改成功则返回一条记录，否则返回0
     * @throws Exception
     */
    boolean updateStudent(Student student) throws Exception;

    /**
     * 添加学生的班级
     *
     * @param students
     * @param classId
     */
    void updateStudentClass(List<Integer> students, Integer classId);

    /**
     * 删除学生信息
     */
    int deleteStudent(int s_id) throws Exception;
}
