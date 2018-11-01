package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.StudentHomeworkMapper;
import cn.kewen.hms.pojo.StudentHomework;
import cn.kewen.hms.service.StudentHomeworkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("studentHomeworkService")
@Transactional
public class StudentHomeworkServiceImpl implements StudentHomeworkService {
    @Resource
    StudentHomeworkMapper studentHomeworkMapper;

    @Override
    public int insertStudentHomework(StudentHomework studentHomework) {
        return studentHomeworkMapper.insertStudentHomework(studentHomework);
    }

    @Override
    public List<StudentHomework> findStudentHomework(Integer teacherId) {
        if (teacherId == null) {
            return new ArrayList<>();
        }
        return studentHomeworkMapper.findStudentHomework(teacherId);
    }

    @Override
    public void addReadHomework(Integer sworkId, Integer sw_grade, String sw_remark) throws Exception {
        if (sworkId == null | sw_grade == null) {
            return;
        }
        studentHomeworkMapper.addReadHomework(sworkId, sw_grade, sw_remark);

    }

}
