package com.xcm.mapper;

import java.util.List;

import com.xcm.entity.CheckIn;
import com.xcm.entity.PageNation;
import com.xcm.entity.Users;

public interface CheckinMapper {
	/**
	 * 得到咨询师和咨询师经理的所有员工分页信息
	 * 
	 * @param pageNation 分页公共类对象
	 * @return 员工类信息集合
	 */
	public List<Users> getZiXunShiList(PageNation pageNation);

	/**
	 * 得到咨询师和咨询师经理的所有员工分页信息总条数
	 * 
	 * @param pageNation 分页公共类对象
	 * @return 总条数
	 */
	public int getZiXunShiCount(PageNation pageNation);

	/**
	 * 根据用户id查到该用户的所有签到记录
	 * 
	 * @param users_Id
	 * @return
	 */
	public List<CheckIn> getChekinListById(int users_Id);

	/**
	 * 根据用户id拿到用户id下的所有签到记录分页方法
	 * 
	 * @param pageNation
	 * @return
	 */
	public List<CheckIn> getChekinListByIdPage(PageNation pageNation);

	/**
	 * 根据用户id拿到用户id下的所有签到记录分页总数据数
	 * 
	 * @param pageNation
	 * @return
	 */
	public int getChekinListByIdCount(PageNation pageNation);

	/**
	 * 一键签到修改用户的签到状态,用来经理签退,和用户一键签到
	 * @param users
	 * @return
	 */
	public int updateOneCheckIn(Users users);
	/**
	 * 根据用户Id查到该用户id最后一条签到记录,用来修改用户签到状态
	 * @param users_Id
	 * @return
	 */
	public CheckIn selectLastCheckInByUsers_Id(int users_Id);
	/**
	 * 修改签到表中的签到状态
	 * @param checkIn
	 * @return
	 */
	public int updateCheckInStatus(CheckIn checkIn);
}
