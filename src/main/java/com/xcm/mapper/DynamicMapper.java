package com.xcm.mapper;

import java.util.List;

import com.xcm.entity.Dynamic;
import com.xcm.entity.PageNation;

public interface DynamicMapper {
	/**
	 * 添加一条动态信息
	 * @return
	 */
	public int addDynamic(Dynamic dynamic);
	/**
	 * 查询一个发送者下的所有动态信息
	 * @return
	 */
	public List<Dynamic> getDynamicByCreator(PageNation pageNation);
	/**
	 * 查询一个发送者下的所有动态信息总条数
	 * @return
	 */
	public int getCountByCreator(PageNation pageNation);
}
