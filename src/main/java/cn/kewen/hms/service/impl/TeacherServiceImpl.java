package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.TeacherMapper;
import cn.kewen.hms.pojo.Teacher;
import cn.kewen.hms.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
    //加载mapper文件
    @Resource
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findTeachers() throws Exception {
        return teacherMapper.findTeachers();
    }

    @Override
    public List<Teacher> findTeacherByName(String t_name) throws Exception {
        return teacherMapper.findTeacherByName(t_name);
    }

    @Override
    public int addTeacher(Teacher teacher) throws Exception {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws Exception {
        int i = teacherMapper.updateTeacher(teacher);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteTeacher(int t_id) throws Exception {
        // TODO Auto-generated method stub
        return teacherMapper.deleteTeacher(t_id);
    }

    @Override
    public String login(int t_id) throws Exception {
        // TODO Auto-generated method stub
        return teacherMapper.findPwdById(t_id);
    }
}
