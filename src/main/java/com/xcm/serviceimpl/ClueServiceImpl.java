package com.xcm.serviceimpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xcm.entity.Clue;
import com.xcm.entity.PageNation;
import com.xcm.mapper.ClueMapper;
import com.xcm.service.ClueService;
import com.xcm.util.Result;
@Service
public class ClueServiceImpl implements ClueService{
	@Resource
	private ClueMapper clueMapper;
	/**
	 * 通过用户Id,查询该用户的所有目标客户
	 * @param users_Id
	 * @return 目标客户信息
	 */
	@Override
	public PageNation getAllByUserId(PageNation pageNation) {
		// TODO Auto-generated method stub
		PageNation page=new PageNation();
		page.setCode(0);
		page.setMsg("");
		page.setCount(clueMapper.getCountByUserId(pageNation));
		page.setData(clueMapper.getPageByUserId(pageNation));
		return page;
	}
	/**
	 * 通过目标学生Id查询单条信息
	 * @param Integer
	 * @return 一条目标学生的详细信息
	 */
	@Override
	public Clue getOneClueById(Integer id) {
		// TODO Auto-generated method stub
		return clueMapper.getOneClueById(id);
	}
	/**
	 * 修改目标学生信息
	 * @param Clue
	 * @return Result
	 */
	@Override
	public Result updateClue(Clue clue) {
		// TODO Auto-generated method stub
		Result result=new Result();
		if(clueMapper.updateClue(clue)>0) {
			result.setMsg("修改成功");
			result.setSuccess(true);
		}else {
			result.setMsg("修改失败");
			result.setSuccess(false);
		}
		return result;
	}
	/**
	 * 放弃目标学生
	 * @param id
	 * @return Result
	 */
	public Result fangQiClue(Integer id) {
		Result result=new Result();
		if(clueMapper.fangQiClue(id)>0) {
			result.setMsg("成功放弃");
			result.setSuccess(true);
		}else {
			result.setMsg("放弃失败");
			result.setSuccess(false);
		}
		return result;
	}
	/**
	 * 目标学生
	 * @param clue
	 * @return Result
	 */
	public Result addClue(Clue clue) {
		Result result=new Result();
		if(clueMapper.addClue(clue)>0) {
			result.setMsg("添加成功");
			result.setSuccess(true);
		}else {
			result.setMsg("添加失败");
			result.setSuccess(false);
		}
		return result;
	}
}
