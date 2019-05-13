package com.xcm.service;

import java.util.List;

import com.xcm.entity.Dynamic;
import com.xcm.entity.PageNation;
import com.xcm.util.Result;

public interface DynamicService {
	/**
	 * 添加一条动态信息
	 * @return
	 */
	public Result addDynamic(Dynamic dynamic);
	/**
	 * 查询一个发送者下的所有动态信息
	 * @return PageNation
	 */
	public PageNation getDynamicByCreator(PageNation pageNation);
}
