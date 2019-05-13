package com.xcm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcm.entity.Distribution;
import com.xcm.mapper.DistributionMapper;
import com.xcm.service.DistributionService;

@Service
public class DistributionServiceImpl implements DistributionService {
	@Autowired
	private DistributionMapper distributionMapper;

	@Override
	public Distribution selectDistributionByUsersId(int distribution_UsersId) {
		// TODO Auto-generated method stub
		return distributionMapper.selectDistributionByUsersId(distribution_UsersId);
	}

	@Override
	public Boolean updateDistributionStatus(Distribution distribution) {
		// TODO Auto-generated method stub
		int num=distributionMapper.updateDistributionStatus(distribution);
		if (num>0) {
			return true;
		}else {
			return false;
		}
	}

}
