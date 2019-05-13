package com.xcm.mapper;

import java.util.List;

import com.xcm.entity.Clue;
import com.xcm.entity.PageNation;

public interface ClueMapper {
	/**
	 * 通过用户Id,查询该用户的所有目标客户,分页显示
	 * @param 分页类
	 * @return 目标客户信息
	 */
	public List<Clue> getPageByUserId(PageNation pageNation);
	/**
	 * 通过用户Id,查询该用户的所有目标客户数据的总条数
	 * @param 分页类
	 * @return 所有目标客户数据的总条数
	 */
	public int getCountByUserId(PageNation pageNation);
	/**
	 * 通过目标学生Id查询单条信息
	 * @param Integer
	 * @return 一条目标学生的详细信息
	 */
	public Clue getOneClueById(Integer id);
	/**
	 * 修改目标学生信息
	 * @param Clue
	 * @return 受影响的行数
	 */
	public int updateClue(Clue clue);
	/**
	 * 放弃目标学生
	 * @param id
	 * @return 受影响的行数
	 */
	public int fangQiClue(Integer id);
	/**
	 * 增加目标学生
	 * @param id
	 * @return 受影响的行数
	 */
	public int addClue(Clue clue);
}
