package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.TeacherMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Teacher;
import cn.kewen.hms.service.TeacherService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public PageData<Teacher> findTeachers(PageParams params) throws Exception {
        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Teacher> result = new PageData<>();
        result.setData(teacherMapper.findTeachers());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public PageData<Teacher> findTeachersNoLesson(PageParams params) throws Exception {
        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Teacher> result = new PageData<>();
        result.setData(teacherMapper.findTeachersNoLesson());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
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
    public boolean updateTeacher(Integer teacherId, Integer lessonId) throws Exception {
        if (teacherId == null || lessonId == null) {
            return false;
        }

        teacherMapper.updateTeacherLesson(teacherId, lessonId);

        return true;
    }

    @Override
    public int deleteTeacher(int t_id) throws Exception {
        // TODO Auto-generated method stub
        return teacherMapper.deleteTeacher(t_id);
    }

    @Override
    public List<String> findNotReadWork(Integer workId) throws Exception {
        if (workId == null){
            return null;
        }
        return teacherMapper.findNotReadWork(workId);
    }

    @Override
    public String login(int t_id) throws Exception {
        // TODO Auto-generated method stub
        return teacherMapper.findPwdById(t_id);
    }
}
