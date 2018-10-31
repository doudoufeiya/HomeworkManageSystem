package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Class;
import cn.kewen.hms.pojo.Lesson;

import java.util.List;

public interface LessonMapper {
    /*
     * 显示所有班级信息
     */
    List<Lesson> findLessons() throws Exception;

    /*
     * 根据姓名查找学生信息
     */
    List<Lesson> findLessonByName(String c_name) throws Exception;

    List<Lesson> findLessonById(String c_id) throws Exception;

    /*
     * 修改信息
     */
    int updateLesson(Lesson lesson) throws Exception;

    /*
     * 添加班级信息
     */
    int addLesson(Lesson lesson) throws Exception;

    /*
     * 删除班级信息
     */
    int deleteLesson(int c_id) throws Exception;
}
