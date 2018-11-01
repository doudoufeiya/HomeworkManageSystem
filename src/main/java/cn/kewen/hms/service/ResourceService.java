package cn.kewen.hms.service;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Question;
import cn.kewen.hms.pojo.Resource;

/**
 * 班级 service
 */
public interface ResourceService {
    /**
     * 查询所有学生信息
     *
     * @param params
     * @return
     * @throws Exception
     */
    PageData<Resource> findResources(PageParams params) throws Exception;

    /**
     * 添加学生信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addResource(Resource resource) throws Exception;


    /**
     * 删除学生信息
     */
    int deleteResource(int s_id) throws Exception;

}
