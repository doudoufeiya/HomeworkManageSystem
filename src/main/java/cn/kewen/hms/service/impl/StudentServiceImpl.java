package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.StudentMapper;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//接口注入，代替Spring配置文件
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    //加载mapper文件
    @Resource
    StudentMapper studentMapper;

    @Override
    public List<Student> findStudents() throws Exception {
        // TODO Auto-generated method stub
        return studentMapper.findStudents();
    }

    @Override
    public List<Student> findStudentByName(String s_name) throws Exception {
        // TODO Auto-generated method stub
        return studentMapper.findStudentByName(s_name);
    }

    @Override
    public int addStudent(Student student) throws Exception {
        // TODO Auto-generated method stub
        return studentMapper.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) throws Exception {
        // TODO Auto-generated method stub
        int i = studentMapper.updateStudent(student);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteStudent(int s_id) throws Exception {
        // TODO Auto-generated method stub
        return studentMapper.deleteStudent(s_id);
    }

    @Override
    public String login(int s_id) throws Exception {
        // TODO Auto-generated method stub
        return studentMapper.findPwdById(s_id);
    }
}
