package cn.kewen.hms.service;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.ScLesson;
import cn.kewen.hms.pojo.Student;

import java.util.List;

public interface ScLessonService {
    /**
     * 查询所有学生信息
     *
     * @param params
     * @return
     * @throws Exception
     */
    PageData<ScLesson> findScLessons(PageParams params) throws Exception;

    /**
     * 查询没有班级的学生
     *
     * @param params
     * @return
     * @throws Exception
     */
//    PageData<ScLesson> findStudentsNoClass(PageParams params) throws Exception;

    /**
     * 登录，根据用户id和密码查找
     *
     * @return
     * @throws Exception
     */
//    String login(int s_id) throws Exception;

    /**
     * 根据学生姓名查询信息
     *
     * @return
     * @throws Exception
     */
//    List<ScLesson> findScLessonByName(String s_name) throws Exception;

    /**
     * 添加学生信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addScLesson(ScLesson scLesson) throws Exception;

    /**
     * 修改学生信息
     *
     * @return 如果修改成功则返回一条记录，否则返回0
     * @throws Exception
     */
    boolean updateScLesson(ScLesson scLesson) throws Exception;

    /**
     * 添加学生的班级
     *
     * @param students
     * @param classId
     */
//    void updateStudentClass(List<Integer> students, Integer classId);

    /**
     * 删除学生信息
     */
    int deleteScLesson(int s_id) throws Exception;
}
