package com.xcm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xcm.service.ModulesService;

@Controller
public class ModulesController {
@Autowired
private ModulesService modulesService;
@RequestMapping("/selectModules")
public @ResponseBody Map<String, Object> selectModules(Integer users_Id) {
	Map<String, Object> map = modulesService.selectByUserId(users_Id);
	//判断map集合是否为空,并添加key给前台做判断
	if(!map.containsKey("name")) {
		map.put("pd", false);
	}else {
		map.put("pd", true);
	}
	System.out.println(map);
	return map;
}

}
