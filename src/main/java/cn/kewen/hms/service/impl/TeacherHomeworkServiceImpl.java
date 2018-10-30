package cn.kewen.hms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.kewen.hms.mapper.TeacherHomeworkMapper;
import cn.kewen.hms.pojo.TeacherHomework;
import cn.kewen.hms.service.TeacherHomeworkService;
@Service("teacherHomeworkService")
@Transactional
public class TeacherHomeworkServiceImpl implements TeacherHomeworkService {
    @Resource
    TeacherHomeworkMapper teacherHomeworkMapper;
	@Override
	public int insertTeacherHomework(TeacherHomework teacherHomework) {
		// TODO Auto-generated method stub
		return teacherHomeworkMapper.insertTeacherHomework(teacherHomework);
	}

	@Override
	public List<TeacherHomework> findTeacherHomework() {
		// TODO Auto-generated method stub
		return teacherHomeworkMapper.findTeacherHomework();
	}

}
