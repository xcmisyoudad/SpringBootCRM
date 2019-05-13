package com.xcm.service;

import java.util.List;

import com.xcm.entity.FollowUp;
import com.xcm.entity.PageNation;
import com.xcm.util.Result;

public interface FollowUpService {
	/**
	 * 增加跟踪信息
	 * @param FollowUp
	 * @return 
	 */
	public Result genZongClue(FollowUp followUp);
	/**
	 * 获取该目标客户的所有跟进记录
	 * @param 目标客户Id
	 * @return 
	 */
	public PageNation getFollowUpByClueId(PageNation pageNation);
}
