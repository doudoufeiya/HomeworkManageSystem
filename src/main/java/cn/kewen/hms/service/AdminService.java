package cn.kewen.hms.service;

import java.util.List;

import cn.kewen.hms.pojo.Admin;

public interface AdminService {
	/**
	 * 查询所有管理员信息
	 * @param managers
	 * @return
	 * @throws Exception
	 */
	public List<Admin> findAdmins() throws Exception;	
	/**
	 * 管理员登录，根据用户id和密码查找
	 * @param managers
	 * @return
	 * @throws Exception
	 */
	public String login(int a_id) throws Exception;
	/**
	 * 根据管理员编号查询信息
	 * @param mid
	 * @return
	 * @throws Exception
	 */
	public List<Admin> findAdminById(int a_id) throws Exception;
	/**
	 * 添加管理员信息
	 * @param managers
	 * @return 如果添加成功则返回true，否则返回false
	 * @throws Exception
	 */
	public int addAdmin(Admin admin) throws Exception;
	/**
	 * 修改管理员信息
	 * @param managers
	 * @return 如果修改成功则返回一条记录，否则返回0。
	 * @throws Exception
	 */
	public boolean updateAdmin(Admin admin) throws Exception;
	/**
	 * 删除管理员信息
	 * @param managers
	 * @return 如果添加成功则返回true，否则返回false
	 * @throws Exception
	 */
	public int deleteAdmin(int a_id) throws Exception;
	
}
