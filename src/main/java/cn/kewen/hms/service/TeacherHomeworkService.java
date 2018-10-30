package cn.kewen.hms.service;

import cn.kewen.hms.pojo.TeacherHomework;

import java.util.List;

public interface TeacherHomeworkService {
    /**
     * 插入信息
     */
    int insertTeacherHomework(TeacherHomework teacherHomework);

    /**
     * 显示所有信息
     */
    List<TeacherHomework> findTeacherHomework();

}
