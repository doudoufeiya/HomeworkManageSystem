package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.StudentHomework;

import java.util.List;

public interface StudentHomeworkMapper {
    /**
     * 插入信息
     */
    int insertStudentHomework(StudentHomework studentHomework);

    /**
     * 显示所有作业信息
     */
    List<StudentHomework> findStudentHomework();
}
