package com.xcm.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcm.entity.Modules;
import com.xcm.mapper.ModulesMapper;
import com.xcm.service.ModulesService;

@Service
public class ModulesServiceImpl implements ModulesService{
@Autowired
private ModulesMapper modulesMapper;
public Map<String,Object> selectLeafNode(Modules modules,Map<String,Object> map){
	List<Modules> selectLeafNode = modulesMapper.selectLeafNode(modules);
	return null;
}
@Override
public Map<String, Object> selectByUserId(Integer users_Id) {
	Map<String,Object> map = new HashMap<String, Object>();
	List<Modules> list = modulesMapper.selectByUserId(users_Id);//查出来该用户下所有模块
	for(int i=0;i<list.size();i++) {
		//说明是顶层节点
		if(list.get(i).getModules_ParentId()==0) {
			//把顶层节点往里面放 查出该节点下面的子节点
			map.put("id",list.get(i).getModules_Id());
			map.put("name", list.get(i).getModules_Name());
			map.put("Path", list.get(i).getModules_Path());
			map.put("ParentId", list.get(i).getModules_ParentId());
			map.put("Weight", list.get(i).getModules_Weight());
			map.put("children", test(list.get(i),map));
		}
	}	
	return map;	
 }
	public List<Map<String,Object>> test(Modules modules,Map<String,Object> map) {
		List<Map<String,Object>> hehe = new ArrayList<Map<String,Object>>();
		List<Modules> list = modulesMapper.selectLeafNode(modules);//查该模块下下面的子模块
		Map<String,Object> haha =null;
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				haha = new HashMap<String, Object>();
				haha.put("id",list.get(i).getModules_Id());
				haha.put("name", list.get(i).getModules_Name());
				haha.put("Path", list.get(i).getModules_Path());
				haha.put("ParentId", list.get(i).getModules_ParentId());
				haha.put("Weight", list.get(i).getModules_Weight());
				//多一个children
				if(!modulesMapper.selectLeafNode(list.get(i)).toString().equals("[]")) {
					haha.put("children", test(list.get(i),haha));
				}
				hehe.add(haha);
				System.out.println(list.get(i).getModules_Id()+"-----"+list.get(i).getModules_ParentId());
			}
		}
		return hehe;
	}
}
