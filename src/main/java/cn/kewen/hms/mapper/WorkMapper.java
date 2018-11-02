package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    /*
     * 显示所有班级信息
     */
    List<Work> findWorks(@Param("tw_name") String tw_name) throws Exception;

    /*
     * 根据姓名查找学生信息
     */
    List<Work> findWorkByName(String c_name) throws Exception;

    List<Work> findWorkById(String c_id) throws Exception;

    /*
     * 修改信息
     */
    int updateWork(Work class1) throws Exception;

    /*
     * 添加班级信息
     */
    int addWork(Work class1) throws Exception;

    /*
     * 删除班级信息
     */
    int deleteWork(int c_id) throws Exception;


}
