package com.caohongtao301.services.impl;

import java.util.List;

import com.caohongtao301.dao.ICompanyInfomationDao301;
import com.caohongtao301.dao.impl.CompanyInfomationDaoImpl301;
import com.caohongtao301.pojo.CompanyInfomation301;
import com.caohongtao301.services.ICompanyInfomationService301;

/** 
* @ClassName: CompanyInfomationServiceImpl301 
* @Description: TODO(other) 
* @author ²ÜºéÌÎ
* @date 2021-11-28 20:22:56 
*  
*/
public class CompanyInfomationServiceImpl301 implements ICompanyInfomationService301 {
ICompanyInfomationDao301 cid301=new CompanyInfomationDaoImpl301();
	@Override
	public List<CompanyInfomation301> queryAll301() {
		// TODO Auto-generated method stub
		return cid301.queryAll301();
	}

	@Override
	public List<CompanyInfomation301> queryByCond301(String condition301) {
		// TODO Auto-generated method stub
		return cid301.queryByCond301(condition301);
	}

	@Override
	public CompanyInfomation301 query301(CompanyInfomation301 ci301) {
		// TODO Auto-generated method stub
		return cid301.query301(ci301);
	}

	@Override
	public int add301(CompanyInfomation301 ci301) {
		// TODO Auto-generated method stub
		return cid301.add301(ci301);
	}

	@Override
	public int update301(CompanyInfomation301 ci301) {
		// TODO Auto-generated method stub
		return cid301.update301(ci301);
	}

	@Override
	public int delete301(CompanyInfomation301 ci301) {
		// TODO Auto-generated method stub
		return cid301.delete301(ci301);
	}

}
