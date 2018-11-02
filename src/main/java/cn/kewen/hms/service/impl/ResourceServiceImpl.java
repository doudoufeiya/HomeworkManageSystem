package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.ResourceMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Resource;
import cn.kewen.hms.service.ResourceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//接口注入，代替Spring配置文件
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
    //加载mapper文件
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageData<Resource> findResources(PageParams params, String r_name) throws Exception {
        if (params == null) {
            params = new PageParams();
        }
        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Resource> result = new PageData<>();
        result.setData(resourceMapper.findResources(r_name));
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public int addResource(Resource resource) throws Exception {
        return resourceMapper.addResource(resource);
    }


    @Override
    public int deleteResource(int s_id) throws Exception {
        return resourceMapper.deleteResource(s_id);
    }

}
