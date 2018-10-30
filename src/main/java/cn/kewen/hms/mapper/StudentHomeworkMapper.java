package cn.kewen.hms.mapper;

import java.util.List;

import cn.kewen.hms.pojo.StudentHomework;

public interface StudentHomeworkMapper {
	/**
	 * 插入信息
	 */
	public int insertStudentHomework(StudentHomework studentHomework);
    /**
     * 显示所有作业信息
     */
	public List<StudentHomework> findStudentHomework();
}
