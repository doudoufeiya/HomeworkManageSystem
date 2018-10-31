package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Class;
import cn.kewen.hms.pojo.ScLesson;

import java.util.List;

/**
 * @author shen
 */
public interface ScLessonMapper {
    /*
     * 显示所有班级信息
     */
    List<ScLesson> findScLesson() throws Exception;

    /*
     * 根据姓名查找学生信息
     */

    List<ScLesson> findScLessonById(String c_id) throws Exception;

    /*
     * 修改信息
     */
    int updateScLesson(ScLesson scLesson) throws Exception;

    /*
     * 添加班级信息
     */
    int addScLesson(ScLesson scLesson) throws Exception;

    /*
     * 删除班级信息
     */
    int deleteScLesson(int c_id) throws Exception;
}
