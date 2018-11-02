package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /*
     * 显示所有学生信息
     */
    List<Student> findStudents(@Param("s_name") String s_name) throws Exception;

    /**
     * @return
     * @throws Exception
     */
    List<Student> findStudentsNoClass() throws Exception;

    /*
     * 根据用户名找密码
     */
    String findPwdById(int s_id) throws Exception;

    /*
     * 根据姓名查找学生信息
     */
    List<Student> findStudentByName(String s_name) throws Exception;

    /*
     * 修改信息
     */
    int updateStudent(Student student) throws Exception;

    /**
     * 修改学生的班级
     *
     * @param studentId
     * @param classId
     */
    void updateStudentClass(@Param("studentId") Integer studentId, @Param("classId") Integer classId);

    /*
     * 添加学生信息
     */
    int addStudent(Student student) throws Exception;

    /*
     * 删除学生信息
     */
    int deleteStudent(int s_id) throws Exception;


    /**
     * 查询没有提交作业的学生
     *
     * @param workId 作业ID
     * @return
     * @throws Exception
     */
    List<String> toCommitWorkStudentNames(@Param("workId") Integer workId) throws Exception;

    /**
     * @param workId
     * @param fileName
     * @param filePath
     * @throws Exception
     */
    void uploadWork(@Param("workId") Integer workId, @Param("fileName") String fileName,
                    @Param("filePath") String filePath, @Param("studentId") Integer studentId) throws Exception;


    /**
     * 获取学生的未提交的作业
     *
     * @param studentId
     * @return
     */
    List<String> getToCommitWorkName(@Param("studentId") Integer studentId);
}
