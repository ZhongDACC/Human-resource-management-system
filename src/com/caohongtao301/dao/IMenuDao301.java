package com.caohongtao301.dao;

import java.util.List;

import com.caohongtao301.pojo.Menu301;


/** 
* @ClassName: IMenuDao301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:21:03 
*  
*/
public interface IMenuDao301 {
	public List<Menu301> queryAll301();//查询所有导航菜单
	public List<Menu301> queryByCond301(String condition301);//条件查询导航菜单
	public Menu301 query301(Menu301 menu301);//根据序号查询导航菜单
	public int add301(Menu301 menu301);//添加导航菜单
	public int update301(Menu301 menu301);//修改导航菜单
	public int delete301(Menu301 menu301);//删除导航菜单
}