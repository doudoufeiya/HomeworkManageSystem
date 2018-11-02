package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMapper {
    /*
     * 显示所有班级信息
     */
    List<Class> findClasss(@Param("c_name") String c_name) throws Exception;

    /*
     * 根据姓名查找学生信息
     */
    List<Class> findClassByName(String c_name) throws Exception;

    List<Class> findClassById(String c_id) throws Exception;

    /*
     * 修改信息
     */
    int updateClass(Class class1) throws Exception;

    /*
     * 添加班级信息
     */
    int addClass(Class class1) throws Exception;

    /*
     * 删除班级信息
     */
    int deleteClass(int c_id) throws Exception;
}
