package cn.kewen.hms.service;

import java.util.List;

import cn.kewen.hms.pojo.TeacherHomework;

public interface TeacherHomeworkService {
	/**
	 * 插入信息
	 */
	public int insertTeacherHomework(TeacherHomework teacherHomework);
    /**
     * 显示所有信息
     */
	public List<TeacherHomework> findTeacherHomework();

}
