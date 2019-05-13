package com.xcm.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcm.entity.PageNation;
import com.xcm.entity.Users;
import com.xcm.service.CheckinService;

@Controller
public class CheckinController {
	@Autowired
	private CheckinService checkinService;

	/**
	 * 页面访问方法
	 * 
	 * @return
	 */
	@RequestMapping("checkinList")
	public String checkinList() {
		return "WeAdmin/pages/order/checkinList";
	}

	/**
	 * 得到咨询师和咨询经理信息的分页查询方法
	 * 
	 * @param pageNation
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getZiXunShiList")
	public PageNation getZiXunShiList(PageNation pageNation) {
		return checkinService.getZiXunShiList(pageNation);
	}

	/**
	 * 根据用户id得到该用户的所有签到记录,储存到模型中,进行页面跳转
	 * 
	 * @param users_Id
	 * @param model
	 * @return
	 */
	@RequestMapping("getChekinListById")
	public String getChekinListById(int users_Id, Model model) {
		model.addAttribute("users_Id", users_Id);
		model.addAttribute("checkinList", checkinService.getChekinListById(users_Id));
		return "WeAdmin/pages/order/oneCheckinList";
	}

	/**
	 * 拿到咨询师用户id下的所有签到记录
	 * 
	 * @param pageNation
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getChekinListByIdPage")
	public PageNation getChekinListByIdPage(PageNation pageNation) {
		System.out.println(pageNation);
		return checkinService.getChekinListByIdPage(pageNation);
	}

	/**
	 * 经理给员工的签退方法
	 * 
	 * @param users
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateOneCheckIn")
	public Boolean updateOneCheckIn(Users users) {
		return checkinService.updateOneCheckIn(users);
	}

	/**
	 * 用户员工的一键签到
	 * @param users
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
	@RequestMapping("updateCheckInByUsers")
	public int updateCheckInByUsers(Users users) throws ParseException {
		System.out.println(users);
		return checkinService.updateCheckInByUsers(users);
	}
}
