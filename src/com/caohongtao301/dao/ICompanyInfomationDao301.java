package com.caohongtao301.dao;



import java.util.List;

import com.caohongtao301.pojo.CompanyInfomation301;




/** 
* @ClassName: ICompanyInfomationDao301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:20:55 
*  
*/
public interface ICompanyInfomationDao301 {
	public List<CompanyInfomation301> queryAll301();//��ѯ���й�˾��Ϣ
	public List<CompanyInfomation301> queryByCond301(String condition301);//������ѯ��˾��Ϣ
	public CompanyInfomation301 query301(CompanyInfomation301 ci301);//������Ų�ѯ��˾��Ϣ
	public int add301(CompanyInfomation301 ci301);//��ӹ�˾��Ϣ
	public int update301(CompanyInfomation301 ci301);//�޸Ĺ�˾��Ϣ
	public int delete301(CompanyInfomation301 ci301);//ɾ����˾��Ϣ
}
