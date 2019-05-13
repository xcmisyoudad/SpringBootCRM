package com.xcm.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xcm.entity.Users;
import com.xcm.mapper.UsersMapper;
import com.xcm.service.UsersService;
import com.xcm.util.PasswordEncrypt;
import com.xcm.util.RandomCreate;
import com.xcm.util.Result;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 通过用户名和密码查询用户
	 * 
	 * @param users
	 * @return Boolean 用户存在return： true 反之 return false
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	@Override
	public Result selectUsers(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Users user2 = usersMapper.selectUsersByUsersName(users);
		Result result = new Result();
		// 如果user2不为空代表用户名存在,进入下一级别判断
		if (user2 != null) {
			// 进行MD5加密
			String password = users.getUsers_Password();
			String jieGuo = PasswordEncrypt.encodeByMd5(password);
			users.setUsers_Password(jieGuo);
			Users user = usersMapper.selectUsers(users);
			// 如果user不为空,那么用户名和密码都正确,进入锁定判断
			if (user != null) {
				result.setSuccess(true);
				if (user.getUsers_LsLockout() == 1) {
					result.setMsg("登录成功");
					result.setIsLockout(1);
					result.setUsers(user);
					usersMapper.updateUserPsdWrongTimeSucessByZero(user);
					return result;
				} else {
					result.setMsg("目前该用户已经被锁定");
					result.setIsLockout(2);
					return result;
				}

			}
			// 那就是用户名正确,密码不对
			else {
				// 如果错误次数到5次,改变状态
				if (user2.getUsers_PsdWrongTime() == 5) {
					int num = 5;
					user2.setUsers_PsdWrongTime(num);
					user2.setUsers_LsLockout(2);
					usersMapper.updateUsersLockout(user2);
					result.setSuccess(true);
					result.setMsg("该账户已经被锁定");
					result.setIsLockout(2);
					return result;
				}
				// 如果错误次数不到5次,提示密码错误
				else {
					int num = user2.getUsers_PsdWrongTime() + 1;
					user2.setUsers_PsdWrongTime(num);
					user2.setUsers_LsLockout(1);
					usersMapper.updateUsersLockout(user2);
					result.setSuccess(false);
					result.setMsg("<a href='javascript:void(0);' onclick='tiJiao()'>密码错误,点击文本进行重置密码操作 </a>");
					result.setIsLockout(1);
					return result;
				}
			}
		}
		// 那就是用户名不存在
		else {
			result.setSuccess(false);
			result.setMsg("用户名不存在");
			result.setIsLockout(1);
			return result;
		}
	}

	@Override
	public Result emailRandom(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Result result = new Result();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("2982756362@qq.com");
		message.setTo(users.getUsers_ProTectEMail());
		message.setSubject("您的重置密码");
		int num = RandomCreate.getRandom();
		message.setText("您好,这是您的邮箱验证码:" + num + "请妥善保管");
		mailSender.send(message);
		result.setSuccess(true);
		String num2 = PasswordEncrypt.encodeByMd5(""+num+"");
		result.setMsg(""+num2+"");
		System.out.println("emailRandom+++++++++++++++++++++++++++++++++++"+result);
		return result;

	}

	@Override
	public Result chongZhiPassword(Users users) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Users user=usersMapper.selectUsersByUsersEmail(users);
		if(user!=null) {
			result.setSuccess(true);
			result.setMsg("成功");
			result.setIsLockout(1);
			result.setUsers(user);
		}
		else {
			result.setSuccess(false);
			result.setMsg("失败");
		}
		return result;
	}

	@Override
	public Boolean updateUsersChongZhiPassword(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String jieGuo=users.getUsers_Password();
		String jieGuo2=PasswordEncrypt.encodeByMd5(jieGuo);
		users.setUsers_Password(jieGuo2);
		int num=usersMapper.updateUsersChongZhiPassword(users);
		if(num>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Users getOneUsersById(Integer id) {
		// TODO Auto-generated method stub
		return usersMapper.getOneUsersById(id);
	}

}
