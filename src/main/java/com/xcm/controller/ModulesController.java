package com.xcm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xcm.entity.Modules;
import com.xcm.service.ModulesService;

@Controller
public class ModulesController {
@Autowired
private ModulesService modulesService;
@RequestMapping("/selectModules")
public @ResponseBody List<Map<String,Object>> selectModules(Integer users_Id) {
	List<Map<String,Object>> list = modulesService.selectByUserId(users_Id);
	return list;
}
}
