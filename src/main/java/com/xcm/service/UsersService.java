package com.xcm.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xcm.entity.Users;
import com.xcm.util.Result;

public interface UsersService {
	/**
	 * CRM系统登录方法,将页面用户名和密码传入
	 * 
	 * @param users
	 * @return 为一个登录辅助类,有成功信息,和是否锁定等参数
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public Result selectUsers(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException;

	/**
	 * 通过用户对象中的邮件信息给发送一个随机数
	 * 
	 * @param users
	 * @return 辅助类
	 */
	public Result emailRandom(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException;

	/**
	 * 传入重置密码的对象返回辅助类用来进行最后的重置密码的操作
	 * 
	 * @param users
	 * @return
	 */
	public Result chongZhiPassword(Users users);

	/**
	 * 完成最后一步的用户密码重置
	 * 
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public Boolean updateUsersChongZhiPassword(Users users)
			throws NoSuchAlgorithmException, UnsupportedEncodingException;

	/**
	 * 生成用户图片验证码
	 * @param request
	 * @param response
	 */
	public void code(HttpServletRequest request, HttpServletResponse response);
}
