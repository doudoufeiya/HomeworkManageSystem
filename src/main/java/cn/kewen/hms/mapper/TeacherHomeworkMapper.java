package cn.kewen.hms.mapper;

import java.util.List;

import cn.kewen.hms.pojo.TeacherHomework;

public interface TeacherHomeworkMapper {
	/**
	 * 插入信息
	 */
	public int insertTeacherHomework(TeacherHomework teacherHomework);
    /**
     * 显示所有作业信息
     */
	public List<TeacherHomework> findTeacherHomework();
}
