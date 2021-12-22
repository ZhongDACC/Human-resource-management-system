package com.caohongtao301.services;



import java.util.List;

import com.caohongtao301.pojo.CompanyInfomation301;



/** 
* @ClassName: ICompanyInfomationService301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:22:31 
*  
*/
public interface ICompanyInfomationService301 {
	public List<CompanyInfomation301> queryAll301();//查询所有公司信息
	public List<CompanyInfomation301> queryByCond301(String condition301);//条件查询公司信息
	public CompanyInfomation301 query301(CompanyInfomation301 ci301);//根据序号查询公司信息
	public int add301(CompanyInfomation301 ci301);//添加公司信息
	public int update301(CompanyInfomation301 ci301);//修改公司信息
	public int delete301(CompanyInfomation301 ci301);//删除公司信息
}
