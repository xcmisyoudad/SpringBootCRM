package com.xcm.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xcm.entity.Dynamic;
import com.xcm.entity.PageNation;
import com.xcm.mapper.DynamicMapper;
import com.xcm.service.DynamicService;
import com.xcm.util.Result;
@Service
public class DynamicServiceImpl implements DynamicService{
@Resource
private DynamicMapper dynamicMapper;
/**
 * 添加一条动态信息
 * @return
 */
	@Override
	public Result addDynamic(Dynamic dynamic) {
		Result result=new Result();
		if(dynamicMapper.addDynamic(dynamic)>0) {
			result.setSuccess(true);
			result.setMsg("发送成功！");
		}else {
			result.setSuccess(false);
			result.setMsg("发送失败！");
		}
		return result;
	}
	/**
	 * 查询一个发送者下的所有动态信息
	 * @return PageNation
	 */
@Override
public PageNation getDynamicByCreator(PageNation pageNation) {
	// TODO Auto-generated method stub
	PageNation pg=new PageNation();
	Integer num=dynamicMapper.getCountByCreator(pageNation);
	Integer limit=pageNation.getLimit();
	if(num%limit==0) {
		pg.setCount(num/limit);
	}else {
		pg.setCount((num/limit)+1);
	}
	pg.setData(dynamicMapper.getDynamicByCreator(pageNation));
	return pg;
}
public static boolean isNumber1(String str) {// 判断整型		
	return str.matches("^\\d+$$");	
	} 	
}
