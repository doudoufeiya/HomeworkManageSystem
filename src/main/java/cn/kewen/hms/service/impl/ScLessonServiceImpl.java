package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.ScLessonMapper;
import cn.kewen.hms.mapper.StudentMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.ScLesson;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.ScLessonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

//接口注入，代替Spring配置文件
@Transactional
public class ScLessonServiceImpl implements ScLessonService {
    //加载mapper文件
    @Resource
    private ScLessonMapper studentMapper;

    @Override
    public PageData<ScLesson> findScLessons(PageParams params) throws Exception {

        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<ScLesson> result = new PageData<>();
        result.setData(studentMapper.findScLesson());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

//    @Override
//    public PageData<ScLesson> findStudentsNoClass(PageParams params) throws Exception {
//        if (params == null) {
//            params = new PageParams();
//        }
//
//        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
//        PageData<Student> result = new PageData<>();
//        result.setData(studentMapper.findStudentsNoClass());
//        result.setPageNumber(page.getPageNum());
//        result.setPageSize(params.getPageSize());
//        result.setTotalRow(page.getTotal());
//        result.setTotalPage(page.getPages());
//        return result;
//    }

//    @Override
//    public List<ScLesson> findScLessonByName(String s_name) throws Exception {
//        return studentMapper.findScLessonByName(s_name);
//    }

    @Override
    public int addScLesson(ScLesson student) throws Exception {
        return studentMapper.addScLesson(student);
    }

    @Override
    public boolean updateScLesson(ScLesson student) throws Exception {
        int i = studentMapper.updateScLesson(student);
        if (i > 0) {
            return true;
        }
        return false;
    }

//    @Override
//    public void updateStudentClass(List<Integer> students, Integer classId) {
//        if (StringUtils.isEmpty(classId) || CollectionUtils.isEmpty(students)) {
//            return;
//        }
//
//        for (Integer student : students) {
//            studentMapper.updateStudentClass(student, classId);
//        }
//    }

    @Override
    public int deleteScLesson(int s_id) throws Exception {
        return studentMapper.deleteScLesson(s_id);
    }

//    @Override
//    public String login(int s_id) throws Exception {
//        return studentMapper.findPwdById(s_id);
//    }
}
