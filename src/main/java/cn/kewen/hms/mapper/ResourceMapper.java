package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {

    /*
     * 显示所有班级信息
     */
    List<Resource> findResources(@Param("r_name") String r_name) throws Exception;

    /**
     * @param c_id
     * @return
     * @throws Exception
     */
    List<Resource> findResourceById(String c_id) throws Exception;

    /*
     * 添加班级信息
     */
    int addResource(Resource resource) throws Exception;

    /*
     * 删除班级信息
     */
    int deleteResource(int c_id) throws Exception;

}
