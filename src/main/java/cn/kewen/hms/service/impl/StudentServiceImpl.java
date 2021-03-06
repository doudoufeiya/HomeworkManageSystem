package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.StudentMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//接口注入，代替Spring配置文件
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    //加载mapper文件
    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageData<Student> findStudents(PageParams params, String s_name) throws Exception {

        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Student> result = new PageData<>();
        result.setData(studentMapper.findStudents(s_name));
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public PageData<Student> findStudentsNoLesson(PageParams params, Integer l_id) throws Exception {
        if (params == null) {
            params = new PageParams();
        }
        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Student> result = new PageData<>();
        if (l_id == null){
            result.setData(studentMapper.findStudents(null));

        }else {
            result.setData(studentMapper.findStudentsNoLesson(l_id));

        }
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public List<Student> findStudentsNoClass(PageParams params) throws Exception {
        if (params == null) {
            params = new PageParams();
        }

        return studentMapper.findStudentsNoClass();
    }

    @Override
    public List<String> toCommitWorkStudentNames(Integer workId) throws Exception {
        if (workId == null) {
            return new ArrayList<>();
        }

        return studentMapper.toCommitWorkStudentNames(workId);
    }

    @Override
    public List<String> getToCommitWorkName(Integer studentId) throws Exception {
        if (studentId == null) {
            return null;
        }
        return studentMapper.getToCommitWorkName(studentId);
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
    public void updateStudentClass(List<Integer> students, Integer classId) {
        if (StringUtils.isEmpty(classId) || CollectionUtils.isEmpty(students)) {
            return;
        }

        for (Integer student : students) {
            studentMapper.updateStudentClass(student, classId);
        }
    }

    @Override
    public int deleteStudent(int s_id) throws Exception {
        return studentMapper.deleteStudent(s_id);
    }

    @Override
    public Student findStudentInfoPwdById(Integer s_id) throws Exception {
        if (s_id == null) {
            return null;
        }
        return studentMapper.findStudentInfoPwdById(s_id);
    }

    @Override
    public Student findStudentById(Integer s_id) {
        if (s_id == null) {
            return null;
        }
        return studentMapper.findStudentById(s_id);
    }

    @Override
    public List<Student> findClassStudents(Integer c_id) throws Exception {
        if (c_id == null) {
            return null;
        }

        return studentMapper.findClassStudents(c_id);
    }

    @Override
    public void deleteClassStudent(Integer c_id) {
        if (c_id == null) {
            return;
        }
        studentMapper.updateClassStudent(c_id);
    }

    @Override
    public List<Student> findselectStudents(Integer l_id) {
        if (l_id == null) {
            return null;
        }
        return studentMapper.findselectStudents(l_id);
    }

    @Override
    public void incrementPoint(Integer s_id) {
        if (s_id == null){
            return;
        }
        studentMapper.incrementPoint(s_id);
    }

    @Override
    public String login(int s_id) throws Exception {
        return studentMapper.findPwdById(s_id);
    }


}
