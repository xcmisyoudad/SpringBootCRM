package com.xcm.mapper;

import java.util.List;

import com.xcm.entity.Modules;

public interface ModulesMapper {
/**
 * 通过用户Id检索当前用户的所有模块
 * @param users_Id
 * @return
 */
public List<Modules> selectByUserId(Integer users_Id);




/**
 * 根据一个module对象查出这个对象到底是不是最底层的节点
* @param modules 模块对象
* @return 
*/
public List<Modules> selectLeafNode(Modules modules);

}
