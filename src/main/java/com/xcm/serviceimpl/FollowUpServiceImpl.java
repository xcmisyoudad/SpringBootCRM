package com.xcm.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xcm.entity.FollowUp;
import com.xcm.entity.PageNation;
import com.xcm.mapper.FollowUpMapper;
import com.xcm.service.FollowUpService;
import com.xcm.util.Result;
@Service
public class FollowUpServiceImpl implements FollowUpService{
	@Resource
	private FollowUpMapper followUpMapper;
	/**
	 * 增加跟踪信息
	 * @param FollowUp
	 * @return 
	 */
	@Override
	public Result genZongClue(FollowUp followUp) {
		Result result=new Result();
		if(followUpMapper.genZongClue(followUp)>0) {
			result.setMsg("跟进成功");
			result.setSuccess(true);
		}else {
			result.setMsg("跟进失败");
			result.setSuccess(false);
		}
		return result;
	}
	/**
	 * 获取该目标客户的所有跟进记录
	 * @param 目标客户Id
	 * @return 
	 */
	public PageNation getFollowUpByClueId(PageNation pageNation){
		PageNation pg=new PageNation();
		pg.setCode(0);
		pg.setMsg("");
		pg.setCount(followUpMapper.getFollowUpCountByClueId(pageNation));
		pg.setData(followUpMapper.getFollowUpByClueId(pageNation));
		return pg;
	}
}
