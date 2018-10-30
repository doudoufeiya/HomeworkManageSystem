package cn.kewen.hms.service;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    /**
     * 查询所有教师信息
     *
     * @param
     * @return
     * @throws Exception
     */
    PageData<Teacher> findTeachers(PageParams params) throws Exception;

    /**
     * 管理员登录，根据用户id和密码查找
     *
     * @param
     * @return
     * @throws Exception
     */
    String login(int t_id) throws Exception;

    /**
     * 根据教师姓名查询信息
     *
     * @param
     * @return
     * @throws Exception
     */
    List<Teacher> findTeacherByName(String t_name) throws Exception;

    /**
     * 添加教师信息
     *
     * @param
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addTeacher(Teacher teacher) throws Exception;

    /**
     * 修改教师信息
     *
     * @param
     * @return 如果修改成功则返回一条记录，否则返回0。
     * @throws Exception
     */
    boolean updateTeacher(Teacher teacher) throws Exception;

    /**
     * 删除教师信息
     */
    int deleteTeacher(int t_id) throws Exception;
}
