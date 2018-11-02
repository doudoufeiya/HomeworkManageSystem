package cn.kewen.hms.service;

import cn.kewen.hms.pojo.Class;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;

import java.util.List;

/**
 * 班级 service
 */
public interface ClassService {
    /**
     * 查询所有学生信息
     *
     * @param params
     * @param c_name
     * @return
     * @throws Exception
     */
    PageData<Class> findClasss(PageParams params, String c_name) throws Exception;


    /**
     * 根据学生姓名查询信息
     *
     * @return
     * @throws Exception
     */
    List<Class> findClassByName(String s_name) throws Exception;

    /**
     * 添加学生信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addClass(Class class1) throws Exception;

    /**
     * 修改学生信息
     *
     * @return 如果修改成功则返回一条记录，否则返回0
     * @throws Exception
     */
    boolean updateClass(Class class1) throws Exception;

    /**
     * 删除学生信息
     */
    int deleteClass(int s_id) throws Exception;
}
