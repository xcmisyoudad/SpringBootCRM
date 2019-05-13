package com.xcm.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcm.entity.Users;
import com.xcm.service.UsersService;
import com.xcm.util.PasswordEncrypt;
import com.xcm.util.Result;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersService;
	/**
	 * 本方法是控制层判断前台用户登录的唯一方法
	 * @param users 前台用户名密码自动交给spring拼成users对象
	 * @param model 模型用于添加数据显示
	 * @param request 用来操作处理session
	 * @param yanZhengMa 前台输入的验证码
	 * @return 页面路径地址为String类型
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("login")
	public String login(Users users, Model model, HttpServletRequest request,String yanZhengMa) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Result result = usersService.selectUsers(users);
		HttpSession session = request.getSession();
		//从session中得到验证码是多少
		String piccode=(String) session.getAttribute("piccode");
		//有可能第一次访问没有输入验证码加上非空判断
		if(yanZhengMa==null) {
			model.addAttribute("msg", result.getMsg());
			return "WeAdmin/login";
		}
		else {
			//接着判断是否前台验证码是否和后台一样
			if(piccode.equals(yanZhengMa)) {
				System.out.println(result);
				//如果一样直接拿到是否登录的辅助类信息
				if (result.getSuccess()) {
					//如果该账户也未曾锁定
					if (result.getIsLockout() == 1) {
						//将该用户信息写入session中,跳转页面
						System.out.println(users);
						session.setAttribute("users", result.getUsers());
						model.addAttribute("users", result.getUsers());
						return "WeAdmin/index";
					} else {
						//否则就说明被锁定,返回登录页面,并输出提示信息
						model.addAttribute("msg", result.getMsg());
						return "WeAdmin/login";
					}

				} else {
					//否则就失败了状态为false,就代表可能密码输入错误,返回登录页面
					model.addAttribute("msg", result.getMsg());
					return "WeAdmin/login";
				}
			}
			else {
				//如果验证码不正确,返回登录页面
				model.addAttribute("msg", "验证码输入错误");
				return "WeAdmin/login";
			}
		}
	}

	// 供前台layui拿到welcome页面
	@RequestMapping("welcome")
	public String welcome() {
		return "WeAdmin/pages/welcome";

	}

	// 供前台layui拿到index页面
	@RequestMapping("index")
	public String index() {
		return "WeAdmin/index";

	}
	// 供前台layui拿到index页面
	@RequestMapping("usersIndex")
	public String usersIndex() {
		return "usersIndex";

	}
	/**
	 * 用户在登录时密码出错,点击找回密码时,跳转的页面
	 * @return
	 */
	@RequestMapping("passwordZhaoHui")
	public String passwordZhaoHui() {
		return "WeAdmin/pages/passwordZhaoHui";

	}
	/**
	 * 用户在前台重置密码处点击发送邮箱验证码的方法
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("zhaoHuiPassword")
	@ResponseBody
	public Result zhaoHuiPassword(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Result result=usersService.emailRandom(users);
		System.out.println(result);
		return result;
	}
	/**
	 * 用户在输完邮箱验证码和密保信息后在前台点击重置后进入的判断方法
	 * @param users
	 * @param model
	 * @param yanZheng
	 * @param youJianFanHui
	 * @return 辅助类,储存状态和信息,供前台ajax做跳转操作
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("chongZhiPassword")
	@ResponseBody
	public Result chongZhiPassword(Users users,Model model,String yanZheng,String youJianFanHui) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Result result=usersService.chongZhiPassword(users);
		System.out.println(result);
		System.out.println(yanZheng);
		System.out.println(youJianFanHui);
		String jieGuo= PasswordEncrypt.encodeByMd5(yanZheng);
		System.out.println(jieGuo);
		if(result.getSuccess()==true&&jieGuo.equals(youJianFanHui)) {
			model.addAttribute("users", result.getUsers());
			return result;
		}
		else {
			result.setSuccess(false);
			return result;
		}
		
	}
	/**
	 * 跳转最后重置的密码的页面方法
	 * @param users_Id
	 * @param users_LoginName
	 * @param model
	 * @return
	 */
	@RequestMapping("tiaoZhuanChongZhiPassword")
	public String  tiaoZhuanChongZhiPassword(Integer users_Id,String users_LoginName,Model model ){
		System.out.println("------"+users_Id+users_LoginName);
		model.addAttribute("users_Id", users_Id);
		model.addAttribute("users_LoginName", users_LoginName);
		return "WeAdmin/pages/chongZhiPassword";
	}
	/**
	 * 最后修改用户的密码,返回布尔类型的信息
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("updateChongZhiPassword")
	@ResponseBody
	public Boolean updateChongZhiPassword(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Boolean jieGuo=usersService.updateUsersChongZhiPassword(users);
		return jieGuo;
	}
	/**
	 * 前台调用生成验证码图片的方法
	 * @param request
	 * @param response
	 */
	@RequestMapping("code")
	public void code(HttpServletRequest request,HttpServletResponse response) {
		usersService.code(request, response);
	}
}
