package cn.kewen.hms.service;

import cn.kewen.hms.pojo.StudentHomework;

import java.util.List;

public interface StudentHomeworkService {
    /**
     * 插入信息
     */
    int insertStudentHomework(StudentHomework studentHomework);

    /**
     * 显示所有信息
     *
     * @param teacherId
     */
    List<StudentHomework> findStudentHomework(Integer teacherId);

    /**
     * 添加批改意见
     *  @param sworkId
     * @param sw_grade
     * @param sw_remark
     */
    void addReadHomework(Integer sworkId,
                         Integer sw_grade,
                         String sw_remark) throws Exception;
}
