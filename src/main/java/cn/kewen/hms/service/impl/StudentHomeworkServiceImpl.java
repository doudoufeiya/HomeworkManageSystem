package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.StudentHomeworkMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.StudentHomework;
import cn.kewen.hms.service.StudentHomeworkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
    public PageData<StudentHomework> findStudentHomework(Integer teacherId, PageParams params, String sw_name) {
        if (teacherId == null) {
            params = new PageParams();
        }
        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<StudentHomework> result = new PageData<>();
        result.setData(studentHomeworkMapper.findStudentHomework(teacherId, sw_name));
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public void addReadHomework(Integer sworkId, Integer sw_grade, String sw_remark) throws Exception {
        if (sworkId == null | sw_grade == null) {
            return;
        }
        studentHomeworkMapper.addReadHomework(sworkId, sw_grade, sw_remark);

    }

}
