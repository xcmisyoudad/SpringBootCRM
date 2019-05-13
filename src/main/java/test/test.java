package test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.xcm.entity.Modules;
import com.xcm.util.PasswordEncrypt;

public class test {
//    @Autowired
//    private static JavaMailSender mailSender;
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
//		
//		List<Map> li = new ArrayList<Map>();
//		Map<String,Object> map=new HashMap<String,Object>();
//		Map<String,Object> map_children;
//		
//		
//		List<Modules> list = new ArrayList<Modules>();
//		Modules m1 = new Modules();
//		m1.setModules_Id(1);
//		m1.setModules_Name("系统管理");
//		m1.setModules_ParentId(0);
//		
//		Modules m2 = new Modules();
//		m2.setModules_Id(2);
//		m2.setModules_Name("用户管理");
//		m2.setModules_ParentId(1);
//		
//		Modules m3 = new Modules();
//		m3.setModules_Id(3);
//		m3.setModules_Name("啊啊管理");
//		m3.setModules_ParentId(2);
//		list.add(m1);
//		list.add(m2);
//		for(int i = 0 ; i < list.size();i++) {
//			if(list.get(i).getModules_ParentId() == 0) {
//				map.put("id",list.get(i).getModules_Id());
//				map.put("name",list.get(i).getModules_Name());
//				li.add(map);
//			}else {
//				for(int j = 0; j < li.size();j++) {
//					if(li.get(j).get("id") == list.get(i).getModules_ParentId()) {
//						map_children = new HashMap<String,Object>();
//						map_children.put("id",list.get(i).getModules_Id());
//						map_children.put("name",list.get(i).getModules_Name());
//						map.put("children", map_children);
//					}
//				}
//				if(list.size() == li.size()) {
//					break;
//				}
//				
//			}
//		}		
//		System.out.println(li);
		
		
//		PasswordEncrypt passwordEncrypt = new PasswordEncrypt();
//		String jieGuo = passwordEncrypt.encodeByMd5("123456");
//		System.out.println(jieGuo);
//		
//		 SimpleMailMessage message = new SimpleMailMessage();
//	        message.setFrom("2982756362@qq.com");
//	        message.setTo("2516673390@qq.com");
//	        message.setSubject("主题：简单邮件");
//	        message.setText("测试邮件内容");
//	        mailSender.send(message);
//        Date date = new Date();
//        //设置要获取到什么样的时间
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        String startTime="8:00";
//        String endTime="11:24";
//        //获取String类型的时间
//        String createdate = sdf.format(date);
//        System.out.println(createdate);
//        Date date1 = sdf.parse(startTime);
//        Date date2 = sdf.parse(endTime);
//        int compareTo = date1.compareTo(date2);
//
//        System.out.println(compareTo);
		
		Date date = new Date();
		// 设置要获取到什么样的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		// 获取String类型的时间
		String createdate = sdf.format(date);
		// 默认上班时间为八点
		String startTime = "8:00";
		// 根据当前时间的时和分判断谁大谁小
		String endTime = sdf2.format(date);
		Date date1 = sdf2.parse(startTime);
		Date date2 = sdf2.parse(endTime);
		int compareTo = date1.compareTo(date2);
		System.out.println(compareTo);
	}


}
