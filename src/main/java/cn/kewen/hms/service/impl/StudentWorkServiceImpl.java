package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.StudentMapper;
import cn.kewen.hms.mapper.StudentWorkMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.pojo.StudentWork;
import cn.kewen.hms.service.StudentWorkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//接口注入，代替Spring配置文件
@Service
@Transactional
public class StudentWorkServiceImpl implements StudentWorkService {
    //加载mapper文件
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentWorkMapper studentWorkMapper;

    @Override
    public PageData<StudentWork> findStudentWorks(PageParams params, Integer studentId) throws Exception {
        if (studentId == null) {
            return new PageData<>();
        }
        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<StudentWork> result = new PageData<>();
        result.setData(studentWorkMapper.findStudentWorks(params, studentId));
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());

        return result;
    }

    @Override
    public PageData<Student> findStudentsNoClass(PageParams params) throws Exception {
        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Student> result = new PageData<>();
        result.setData(studentMapper.findStudentsNoClass());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public List<String> toCommitWorkStudentNames(Integer workId) throws Exception {
        if (workId == null) {
            return new ArrayList<>();
        }

        return studentMapper.toCommitWorkStudentNames(workId);
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
    public String login(int s_id) throws Exception {
        return studentMapper.findPwdById(s_id);
    }
}
