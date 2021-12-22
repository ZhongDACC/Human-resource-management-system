package com.caohongtao301.services.impl;

import java.util.List;

import com.caohongtao301.dao.IMenuDao301;
import com.caohongtao301.dao.impl.MenuDaoImpl301;
import com.caohongtao301.pojo.Menu301;
import com.caohongtao301.services.IMenuService301;


/** 
* @ClassName: MenuServiceImpl301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:23:03 
*  
*/
public class MenuServiceImpl301 implements IMenuService301 {

	IMenuDao301 iMenDao301=new MenuDaoImpl301();
	@Override
	public List<Menu301> queryAll301() {//查询所有导航菜单信息
		// TODO Auto-generated method stub
		return iMenDao301.queryAll301();//调用dao层查询所有导航菜单信息的方法
	}

	@Override
	public List<Menu301> queryByCond301(String condition301) {//查询所有满足条件的导航菜单信息
		// TODO Auto-generated method stub
		return iMenDao301.queryByCond301(condition301);
	}

	@Override
	public Menu301 query301(Menu301 menu301) {//查询某一个导航菜单信息
		System.out.println("4-edit.MenuServiceImpl301——已成功调用服务层方法"+menu301);
		return iMenDao301.query301(menu301);
	}

	@Override
	public int add301(Menu301 menu301) {//添加导航菜单信息
		// TODO Auto-generated method stub
		return iMenDao301.add301(menu301);
	}

	@Override
	public int update301(Menu301 menu301) {//更新所有导航菜单信息
		// TODO Auto-generated method stub
		return iMenDao301.update301(menu301);
	}

	@Override
	public int delete301(Menu301 menu301) {//删除所有
		// TODO Auto-generated method stub
		return iMenDao301.delete301(menu301);
	}

}
