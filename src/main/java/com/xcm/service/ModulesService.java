package com.xcm.service;

import java.util.List;
import java.util.Map;

import com.xcm.entity.Modules;

public interface ModulesService {
	/**
	 * 通过用户Id检索当前用户的所以模块
	 * @param users_Id
	 * @return
	 */
	public List<Map<String,Object>> selectByUserId(Integer users_Id);
}
