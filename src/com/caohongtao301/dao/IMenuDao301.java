package com.caohongtao301.dao;

import java.util.List;

import com.caohongtao301.pojo.Menu301;


/** 
* @ClassName: IMenuDao301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:21:03 
*  
*/
public interface IMenuDao301 {
	public List<Menu301> queryAll301();//��ѯ���е����˵�
	public List<Menu301> queryByCond301(String condition301);//������ѯ�����˵�
	public Menu301 query301(Menu301 menu301);//������Ų�ѯ�����˵�
	public int add301(Menu301 menu301);//��ӵ����˵�
	public int update301(Menu301 menu301);//�޸ĵ����˵�
	public int delete301(Menu301 menu301);//ɾ�������˵�
}