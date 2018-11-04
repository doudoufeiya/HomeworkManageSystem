package cn.kewen.hms.service;

import cn.kewen.hms.pojo.Admin;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;

import java.util.List;

public interface AdminService {
    /**
     * 查询所有管理员信息
     *
     * @return
     * @throws Exception
     */
    List<Admin> findAdmins() throws Exception;
    PageData<Admin> findAdminsByPage(PageParams params) throws Exception;

    /**
     * 管理员登录，根据用户id和密码查找
     *
     * @return
     * @throws Exception
     */
    String login(int a_id) throws Exception;

    /**
     * 根据管理员编号查询信息
     *
     * @return
     * @throws Exception
     */
    List<Admin> findAdminById(int a_id) throws Exception;
    PageData<Admin> findAdminPageById(Integer a_id) throws Exception;

    /**
     * 添加管理员信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addAdmin(Admin admin) throws Exception;

    /**
     * 修改管理员信息
     *
     * @return 如果修改成功则返回一条记录，否则返回0。
     * @throws Exception
     */
    boolean updateAdmin(Admin admin) throws Exception;

    /**
     * 删除管理员信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int deleteAdmin(int a_id) throws Exception;

}
