package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.TeacherHomeworkMapper;
import cn.kewen.hms.pojo.TeacherHomework;
import cn.kewen.hms.service.TeacherHomeworkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherHomeworkService")
@Transactional
public class TeacherHomeworkServiceImpl implements TeacherHomeworkService {
    @Resource
    TeacherHomeworkMapper teacherHomeworkMapper;

    @Override
    public int insertTeacherHomework(TeacherHomework teacherHomework) {
        return teacherHomeworkMapper.insertTeacherHomework(teacherHomework);
    }

    @Override
    public List<TeacherHomework> findTeacherHomework() {
        return teacherHomeworkMapper.findTeacherHomework();
    }

}
