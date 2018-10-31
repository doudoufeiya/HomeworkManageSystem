package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.ClassMapper;
import cn.kewen.hms.mapper.WorkMapper;
import cn.kewen.hms.pojo.Class;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Work;
import cn.kewen.hms.service.WorkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//接口注入，代替Spring配置文件
@Service
@Transactional
public class WorkServiceImpl implements WorkService {
    //加载mapper文件
    @Resource
    private WorkMapper workMapper;

    @Override
    public PageData<Work> findWorks(PageParams params) throws Exception {
        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Work> result = new PageData<>();
        result.setData(workMapper.findWorks());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public List<Work> findWorkByName(String s_name) throws Exception {
        return workMapper.findWorkByName(s_name);
    }

    @Override
    public int addWork(Work class1) throws Exception {
        return workMapper.addWork(class1);
    }

    @Override
    public boolean updateWork(Work class1) throws Exception {
        int i = workMapper.updateWork(class1);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteWork(int s_id) throws Exception {
        return workMapper.deleteWork(s_id);
    }
}
