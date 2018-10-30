package cn.kewen.hms.service;

import java.util.List;

import cn.kewen.hms.pojo.StudentHomework;

public interface StudentHomeworkService {
	/**
	 * 插入信息
	 */
	public int insertStudentHomework(StudentHomework studentHomework);
    /**
     * 显示所有信息
     */
	public List<StudentHomework> findStudentHomework();
}
