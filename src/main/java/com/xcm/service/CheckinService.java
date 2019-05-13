package com.xcm.service;

import java.text.ParseException;
import java.util.List;
import com.xcm.entity.CheckIn;
import com.xcm.entity.PageNation;
import com.xcm.entity.Users;

public interface CheckinService {
	/**
	 * 得到所有的咨询师和咨询师经理的信息存入到分页公告类中
	 * 
	 * @param pageNation 有查询条件的分页公告类
	 * @return 有着员工信息的分页公共类
	 */
	public PageNation getZiXunShiList(PageNation pageNation);

	/**
	 * 根据员工id得到该员工的所有签到记录
	 * 
	 * @param users_Id
	 * @return 员工类集合
	 */
	public List<CheckIn> getChekinListById(int users_Id);

	/**
	 * 找到用户id下的所有签到记录分页方法
	 * 
	 * @param pageNation
	 * @return
	 */
	public PageNation getChekinListByIdPage(PageNation pageNation);

	/**
	 * 咨询经理用来修改咨询师一键签退的方法
	 * 
	 * @param users
	 * @return
	 */
	public Boolean updateOneCheckIn(Users users);
	
	

	/**
	 * 用户签到方法
	 * @param users
	 * @return
	 */
	public int updateCheckInByUsers(Users users)throws ParseException;
}
