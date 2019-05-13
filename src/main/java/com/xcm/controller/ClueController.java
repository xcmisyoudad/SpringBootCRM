package com.xcm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcm.entity.Clue;
import com.xcm.entity.Dynamic;
import com.xcm.entity.FollowUp;
import com.xcm.entity.PageNation;
import com.xcm.entity.Users;
import com.xcm.mapper.UsersMapper;
import com.xcm.service.ClueService;
import com.xcm.service.DynamicService;
import com.xcm.service.FollowUpService;
import com.xcm.service.UsersService;
import com.xcm.util.Result;

@Controller
public class ClueController {
	@Resource
	ClueService clueService;
	@Resource
	UsersService usersService;
	@Resource
	FollowUpService followUpService;
	@Resource
	DynamicService dynamicService;
	/**
	 * 转发到我们的目标用户数据页面
	 * @return
	 */
	@RequestMapping("Clue/clue")
	public String tiaozhuan() {
		return "WeAdmin/pages/clue/clueList";
	}
	/**
	 * 获取目标客户的分页数据
	 * @return
	 */
	@RequestMapping("Clue/getPage")
	@ResponseBody
	public PageNation getPage(PageNation pageNation,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer usersId=(Integer) session.getAttribute("usersId");
		pageNation.setNum1(usersId);
		return clueService.getAllByUserId(pageNation);
	}
	/**
	 * 查看目标学生的单条信息，转发到查看页面
	 * @return
	 */
	@RequestMapping("Clue/clueChaKan/{id}")
	public String chakan(@PathVariable Integer id,Model model) {
		Clue clue= clueService.getOneClueById(id);
		Users users=usersService.getOneUsersById(clue.getClue_Creator());
		model.addAttribute("clue", clue);
		model.addAttribute("users", users);
		return "WeAdmin/pages/clue/clueChaKan";
	}
	/**
	 * 查看目标学生的单条信息，转发到修改页面
	 * @return
	 */
	@RequestMapping("Clue/clueUpdate/{id}")
	public String update(@PathVariable Integer id,Model model) {
		Clue clue= clueService.getOneClueById(id);
		Users users=usersService.getOneUsersById(clue.getClue_Creator());
		model.addAttribute("clue", clue);
		model.addAttribute("users", users);
		return "WeAdmin/pages/clue/clueUpdate";
	}
	/**
	 * 修改目标学生信息
	 * @return
	 */
	@RequestMapping("Clue/clueUpdate")
	@ResponseBody
	public Result updateClue(Clue clue) {
		return clueService.updateClue(clue);
	}
	/**
	 * 放弃目标学生
	 * @return
	 */
	@RequestMapping("Clue/fangqi")
	@ResponseBody
	public Result fangqi(Integer id,Model model) {
		System.out.println(id);
		return clueService.fangQiClue(id);
	}
	/**
	 * 查询单条信息，转发到跟进页面
	 * @return
	 */
	@RequestMapping("Clue/genZong/{id}")
	public String genZong(@PathVariable Integer id,Model model) {
		Clue clue= clueService.getOneClueById(id);
		model.addAttribute("clue", clue);
		return "WeAdmin/pages/clue/clueGenZong";
	}
	/**
	 * 跟进目标学生
	 * @return
	 */
	@RequestMapping("Clue/genjinClue")
	@ResponseBody
	public Result genjin(FollowUp followUp) {
		return followUpService.genZongClue(followUp);
	}
	/**
	 * 目标学生的所有跟进记录
	 * @return
	 */
	@RequestMapping("Clue/genjinContent")
	@ResponseBody
	public PageNation genjinContent(PageNation pageNation) {
		return followUpService.getFollowUpByClueId(pageNation);
	}
	/**
	 * 转发到增加目标学生页面
	 * @return
	 */
	@RequestMapping("Clue/add")
	public String add() {
		return "WeAdmin/pages/clue/clueAdd";
	}
	/**
	 * 增加目标学生
	 * @return
	 */
	@RequestMapping("Clue/addClue")
	@ResponseBody
	public Result addClue(Clue clue,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer clue_Creator=(Integer) session.getAttribute("usersId");
		clue.setClue_Creator(clue_Creator);
		return clueService.addClue(clue);
	}
	/**
	 * 转发到发送动态信息页面
	 * @return
	 */
	@RequestMapping("Clue/dynamic/{id}")
	public String dynamic(@PathVariable Integer id,Model model) {
		Clue clue= clueService.getOneClueById(id);
		model.addAttribute("clue", clue);
		return "WeAdmin/pages/clue/clueFSDynamic";
	}
	/**
	 * 添加一条动态信息（发送动态信息）
	 * @return
	 */
	@RequestMapping("Clue/addDynamic")
	@ResponseBody
	public Result addDynamic(Dynamic dynamic,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer dynamic_Creator=(Integer) session.getAttribute("usersId");
		dynamic.setDynamic_Creator(dynamic_Creator);
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String dynamic_CreateTime=sim.format(new Date());
		dynamic.setDynamic_CreateTime(dynamic_CreateTime);
		return dynamicService.addDynamic(dynamic);
	}
	/**
	 * 查询一个发送者下的所有动态信息
	 * @return PageNation
	 */
	@RequestMapping("Clue/getDynamicByCreator")
	@ResponseBody
public PageNation getDynamicByCreator(PageNation pageNation,HttpServletRequest request) {
		System.out.println(pageNation);
		HttpSession session = request.getSession();
		Integer dynamic_Creator=(Integer) session.getAttribute("usersId");
		pageNation.setNum1(dynamic_Creator);
	return dynamicService.getDynamicByCreator(pageNation);
}
}
