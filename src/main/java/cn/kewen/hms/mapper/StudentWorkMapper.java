package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.StudentWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentWorkMapper {

    /**
     *
     * @param params
     * @param studentId
     * @return
     */
    List<StudentWork> findStudentWorks(PageParams params, @Param("studentId") Integer studentId);
}

