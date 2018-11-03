package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.AdminMapper;
import cn.kewen.hms.pojo.Admin;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.service.AdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//接口注入，代替Spring配置文件
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    //加载mapper文件
    @Resource
    AdminMapper adminMapper;

    @Override
    public List<Admin> findAdmins() throws Exception {
        return adminMapper.findAdmins();
    }

    @Override
    public PageData<Admin> findAdminsByPage(PageParams params) throws Exception {
        if (params == null){
            params = new PageParams();
        }
        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Admin> result = new PageData<>();
        result.setData(adminMapper.findAdmins());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public String login(int a_id) throws Exception {
        return adminMapper.findPwdById(a_id);
    }

    @Override
    public List<Admin> findAdminById(int a_id) throws Exception {
        return adminMapper.findAdminById(a_id);
    }

    @Override
    public PageData<Admin> findAdminPageById(Integer a_id) throws Exception {
        PageParams params = new PageParams();
        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Admin> result = new PageData<>();
        result.setData(adminMapper.findAdminById(a_id));
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public int addAdmin(Admin admin) throws Exception {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public boolean updateAdmin(Admin admin) throws Exception {
        int i = adminMapper.updateAdmin(admin);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int deleteAdmin(int a_id) throws Exception {
        return adminMapper.deleteAdmin(a_id);
    }
}
