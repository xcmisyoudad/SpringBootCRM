package com.xcm.mapper;

import java.util.List;

import com.xcm.entity.FollowUp;
import com.xcm.entity.PageNation;

public interface FollowUpMapper {
	/**
	 * 增加跟踪信息
	 * @param FollowUp
	 * @return 
	 */
	public int genZongClue(FollowUp followUp);
	/**
	 * 获取该目标客户的所有跟进记录
	 * @param 分页类
	 * @return 
	 */
	public List<FollowUp> getFollowUpByClueId(PageNation pageNation);
	/**
	 * 获取该目标客户的所有跟进记录总条数
	 * @param 分页类
	 * @return 
	 */
	public int getFollowUpCountByClueId(PageNation pageNation);
	
}
