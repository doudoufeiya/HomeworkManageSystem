package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.StudentHomeworkMapper;
import cn.kewen.hms.pojo.StudentHomework;
import cn.kewen.hms.service.StudentHomeworkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("studentHomeworkService")
@Transactional
public class StudentHomeworkServiceImpl implements StudentHomeworkService {
    @Resource
    StudentHomeworkMapper studentHomeworkMapper;

    @Override
    public int insertStudentHomework(StudentHomework studentHomework) {
        // TODO Auto-generated method stub
        return studentHomeworkMapper.insertStudentHomework(studentHomework);
    }

    @Override
    public List<StudentHomework> findStudentHomework() {
        // TODO Auto-generated method stub
        return studentHomeworkMapper.findStudentHomework();
    }

}
