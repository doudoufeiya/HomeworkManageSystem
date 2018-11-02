package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.LessonMapper;
import cn.kewen.hms.pojo.Lesson;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.service.LessonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//接口注入，代替Spring配置文件
@Service
@Transactional
public class LessonServiceImpl implements LessonService {
    //加载mapper文件
    @Resource
    private LessonMapper lessonMapper;

    @Override
    public PageData<Lesson> findLessons(PageParams params, String l_name) throws Exception {

        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Lesson> result = new PageData<>();
        result.setData(lessonMapper.findLessons(l_name));
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

//    @Override
//    public PageData<Student> findStudentsNoClass(PageParams params) throws Exception {
//        if (params == null) {
//            params = new PageParams();
//        }
//
//        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
//        PageData<Student> result = new PageData<>();
//        result.setData(lessonMapper.findStudentsNoClass());
//        result.setPageNumber(page.getPageNum());
//        result.setPageSize(params.getPageSize());
//        result.setTotalRow(page.getTotal());
//        result.setTotalPage(page.getPages());
//        return result;
//    }

    @Override
    public List<Lesson> findStudentByName(String s_name) throws Exception {
        return lessonMapper.findLessonByName(s_name);
    }

    @Override
    public int addLesson(Lesson lesson) throws Exception {
        return lessonMapper.addLesson(lesson);
    }

    @Override
    public boolean updateLesson(Lesson student) throws Exception {
        int i = lessonMapper.updateLesson(student);
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
    public int deleteLesson(int s_id) throws Exception {
        return lessonMapper.deleteLesson(s_id);
    }
}
