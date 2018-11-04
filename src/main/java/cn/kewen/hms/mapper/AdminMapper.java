package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    /*
     * 显示所有管理员信息
     */
    List<Admin> findAdmins() throws Exception;

    /*
     * 根据用户名找密码
     */
    String findPwdById(int a_id) throws Exception;

    /*
     * 根据id查找管理员信息
     */
    List<Admin> findAdminById(int a_id) throws Exception;

    /*
     * 修改信息
     */
    int updateAdmin(Admin admin) throws Exception;

    /*
     * 添加管理员信息
     */
    int addAdmin(Admin admin) throws Exception;

    /*
     * 删除管理员信息
     */
    int deleteAdmin(int a_id) throws Exception;

}
