package com.xcm.service;

import com.xcm.entity.Distribution;

public interface DistributionService {
	/**
	 * 本方法是根据用户id查询到对应的分配状态
	 * @param distribution_UsersId
	 * @return
	 */
	public  Distribution selectDistributionByUsersId(int distribution_UsersId);
	
	/**
	 * 前台修改自动分配的状态方法
	 * @param distribution
	 * @return
	 */
	public Boolean updateDistributionStatus(Distribution distribution);
}
