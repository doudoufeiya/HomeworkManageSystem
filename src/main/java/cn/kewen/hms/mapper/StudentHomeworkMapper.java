package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.StudentHomework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentHomeworkMapper {
    /**
     * 插入信息
     */
    int insertStudentHomework(StudentHomework studentHomework);

    /**
     * 显示所有作业信息
     *
     * @param teacherId
     * @param sw_name
     */
    List<StudentHomework> findStudentHomework(@Param("teacherId") Integer teacherId, @Param("sw_name") String sw_name);


    /**
     * @param sworkId
     * @param sw_grade
     * @param sw_remark
     */
    void addReadHomework(@Param("sworkId") Integer sworkId,
                         @Param("sw_grade") Integer sw_grade,
                         @Param("sw_remark") String sw_remark) throws Exception;
}
