package cn.kewen.hms.service;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.StudentHomework;

public interface StudentHomeworkService {
    /**
     * 插入信息
     */
    int insertStudentHomework(StudentHomework studentHomework);

    /**
     * 显示所有信息
     *  @param teacherId
     * @param params
     * @param homeworkName
     */
    PageData<StudentHomework> findStudentHomework(Integer teacherId, PageParams params, String sw_name);

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
