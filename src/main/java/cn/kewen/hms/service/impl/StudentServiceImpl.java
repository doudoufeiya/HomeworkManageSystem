package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.StudentMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    private StudentMapper studentMapper;

    @Override
    public PageData<Student> findStudents() throws Exception {
        Page page = PageHelper.startPage(1, 5, true);
        PageData<Student> result = new PageData<>();
        result.setData(studentMapper.findStudents());
        result.setTotal(page.getTotal());
        result.setNowPage(1);
        return result;
    }

    @Override
    public List<Student> findStudentByName(String s_name) throws Exception {
        return studentMapper.findStudentByName(s_name);
    }

    @Override
    public int addStudent(Student student) throws Exception {
        return studentMapper.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) throws Exception {
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
