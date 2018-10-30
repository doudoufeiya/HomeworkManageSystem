package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.TeacherHomework;

import java.util.List;

public interface TeacherHomeworkMapper {
    /**
     * 插入信息
     */
    int insertTeacherHomework(TeacherHomework teacherHomework);

    /**
     * 显示所有作业信息
     */
    List<TeacherHomework> findTeacherHomework();
}
