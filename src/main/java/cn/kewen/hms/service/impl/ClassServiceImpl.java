package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.ClassMapper;
import cn.kewen.hms.pojo.Class;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Student;
import cn.kewen.hms.service.ClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//接口注入，代替Spring配置文件
@Service("classService")
@Transactional
public class ClassServiceImpl implements ClassService {
    //加载mapper文件
    @Resource
    private ClassMapper classMapper;

    @Override
    public PageData<Class> findClasss(PageParams params) throws Exception {
        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Class> result = new PageData<>();
        result.setData(classMapper.findClasss());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public List<Class> findClassByName(String s_name) throws Exception {
        return classMapper.findClassByName(s_name);
    }

    @Override
    public int addClass(Class class1) throws Exception {
        return classMapper.addClass(class1);
    }

    @Override
    public boolean updateClass(Class class1) throws Exception {
        int i = classMapper.updateClass(class1);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteClass(int s_id) throws Exception {
        return classMapper.deleteClass(s_id);
    }
}