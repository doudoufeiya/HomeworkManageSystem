package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.AdminMapper;
import cn.kewen.hms.pojo.Admin;
import cn.kewen.hms.service.AdminService;
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
    public String login(int a_id) throws Exception {
        return adminMapper.findPwdById(a_id);
    }

    @Override
    public List<Admin> findAdminById(int a_id) throws Exception {
        return adminMapper.findAdminById(a_id);
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
