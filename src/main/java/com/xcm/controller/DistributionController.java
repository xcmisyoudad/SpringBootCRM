package com.xcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcm.entity.Distribution;
import com.xcm.service.DistributionService;

@Controller
public class DistributionController {
	@Autowired
	private DistributionService distributionService;
	@RequestMapping("selectDistributionByUsersId")
	@ResponseBody
	public Distribution selectDistributionByUsersId(int distribution_UsersId,Model model) {
			model.addAttribute("distribution", distributionService.selectDistributionByUsersId(distribution_UsersId));
			return distributionService.selectDistributionByUsersId(distribution_UsersId);
	}
	@RequestMapping("tiaoZhuanDistribution")
	public String tiaoZhuanDistribution(Model model) {
		return "WeAdmin/pages/order/distribution";
	}
	@RequestMapping("updateDistributionStatus")
	@ResponseBody
	public Boolean updateDistributionStatus(Distribution distribution) {
		// TODO Auto-generated method stub
		return distributionService.updateDistributionStatus(distribution);
	}
}
