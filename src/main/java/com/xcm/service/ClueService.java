package com.xcm.service;

import com.xcm.entity.Clue;
import com.xcm.entity.PageNation;
import com.xcm.util.Result;


public interface ClueService {
	/**
	 * 通过用户Id,查询该用户的所有目标客户
	 * @param users_Id
	 * @return 目标客户信息
	 */
	public PageNation getAllByUserId(PageNation pageNation);
	/**
	 * 通过目标学生Id查询单条信息
	 * @param Integer
	 * @return 一条目标学生的详细信息
	 */
	public Clue getOneClueById(Integer id);
	/**
	 * 修改目标学生信息
	 * @param Clue
	 * @return Result
	 */
	public Result updateClue(Clue clue);
	/**
	 * 放弃目标学生
	 * @param id
	 * @return Result
	 */
	public Result fangQiClue(Integer id);
	/**
	 * 目标学生
	 * @param clue
	 * @return Result
	 */
	public Result addClue(Clue clue);
}
