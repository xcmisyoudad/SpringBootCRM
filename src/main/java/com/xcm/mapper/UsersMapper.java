package com.xcm.mapper;

import com.xcm.entity.Users;

public interface UsersMapper {

	/**
	 * 通过用户名和密码和查询用户
	 * 
	 * @param users
	 * @return
	 */
	public Users selectUsers(Users users);

	/**
	 * 通过用户名查询用户是否存在
	 * 
	 * @param users
	 * @return
	 */
	public Users selectUsersByUsersName(Users users);

	/**
	 * 用户密码错误后修改密码的错误次数和锁定状态
	 * 
	 * @param users
	 * @return
	 */
	public Integer updateUsersLockout(Users users);

	/**
	 * 用户登录成功后修改失败次数为初始值(0)的方法
	 * 
	 * @param users
	 * @return
	 */
	public Integer updateUserPsdWrongTimeSucessByZero(Users users);

	/**
	 * 根据用户的用户名,用户邮箱,手机号进行查找返回用户
	 * 
	 * @param users
	 * @return
	 */
	public Users selectUsersByUsersEmail(Users users);

	/**
	 * 修改用户的重置密码,这个方法的调用代表重置密码的流程到此结束
	 * @param users
	 * @return
	 */
	public Integer updateUsersChongZhiPassword(Users users);
	/**
	 * 通过用户Id查询单条信息
	 * @param Integer
	 * @return
	 */
	public Users getOneUsersById(Integer id);
	
}
