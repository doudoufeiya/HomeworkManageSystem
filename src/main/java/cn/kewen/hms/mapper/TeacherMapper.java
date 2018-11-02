package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    /*
     * 显示所有信息
     */
    List<Teacher> findTeachers(@Param("t_name") String t_name) throws Exception;

    List<Teacher> findTeachersNoLesson() throws Exception;

    /*
     * 根据用户名找密码
     */
    String findPwdById(int t_id) throws Exception;

    /*
     * 根据姓名查找信息
     */
    List<Teacher> findTeacherByName(String t_name) throws Exception;

    /*
     * 修改信息
     */
    int updateTeacher(Teacher teacher) throws Exception;

    int updateTeacherLesson(@Param("teacherId") Integer teacherId, @Param("lessonId") Integer lessonId) throws Exception;

    /*
     * 添加信息
     */
    int addTeacher(Teacher teacher) throws Exception;

    /*
     * 删除信息
     */
    int deleteTeacher(int t_id) throws Exception;

    /**
     * 找到未批改的作业
     *
     * @param workId
     * @return
     * @throws Exception
     */
    List<String> findNotReadWork(Integer workId) throws Exception;

    Teacher findTeacherById(@Param("t_id") Integer t_id);

    void deleteTeacherLesson(@Param("l_id") Integer l_id);

//    void incrementPoint(@Param("t_id") Integer t_id);
}
