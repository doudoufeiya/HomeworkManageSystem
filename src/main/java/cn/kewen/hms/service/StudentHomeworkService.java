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
     * @param teacherId
     */
    List<StudentHomework> findStudentHomework(Integer teacherId);
}
