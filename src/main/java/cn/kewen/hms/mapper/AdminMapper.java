package cn.kewen.hms.mapper;

import java.util.List;

import cn.kewen.hms.pojo.Admin;

public interface AdminMapper {
	/*
	 * 显示所有管理员信息
	 */
	public List<Admin> findAdmins() throws Exception;
	/*
	 * 根据用户名找密码
	 */
	public String findPwdById(int a_id) throws Exception;
	/*
	 * 根据id查找管理员信息
	 */
	public List<Admin> findAdminById(int a_id) throws Exception;
	/*
	 * 修改信息
	 */
	public int updateAdmin(Admin admin) throws Exception;
	/*
	 * 添加管理员信息
	 */
	public int addAdmin(Admin admin) throws Exception;
	/*
	 * 删除管理员信息
	 */
	public int deleteAdmin(int a_id) throws Exception;
	
}
