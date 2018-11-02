package cn.kewen.hms.service;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Work;

import java.util.List;

/**
 * 班级 service
 */
public interface WorkService {
    /**
     * 查询所有学生信息
     *
     * @param params
     * @param tw_name
     * @return
     * @throws Exception
     */
    PageData<Work> findWorks(PageParams params, String tw_name) throws Exception;


    /**
     * 根据学生姓名查询信息
     *
     * @return
     * @throws Exception
     */
    List<Work> findWorkByName(String s_name) throws Exception;

    /**
     * 添加学生信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addWork(Work class1) throws Exception;

    /**
     * 修改学生信息
     *
     * @return 如果修改成功则返回一条记录，否则返回0
     * @throws Exception
     */
    boolean updateWork(Work class1) throws Exception;

    /**
     * 删除学生信息
     */
    int deleteWork(int s_id) throws Exception;
}
