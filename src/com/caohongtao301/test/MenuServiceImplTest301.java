package com.caohongtao301.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.caohongtao301.pojo.Menu301;
import com.caohongtao301.services.IMenuService301;
import com.caohongtao301.services.impl.MenuServiceImpl301;

/** 
* @ClassName: MenuServiceImplTest301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:23:27 
*  
*/
class MenuServiceImplTest301 {

	/*
	 * @BeforeAll static void setUpBeforeClass() throws Exception { }
	 * 
	 * @AfterAll static void tearDownAfterClass() throws Exception { }
	 */

    //����IMenuService301�ӿ����ͱ���ims301��ims301��ʵ����MenuServiceImpl301�ľ���ʵ��
	IMenuService301 ims301=new MenuServiceImpl301();
	@Test
	void testQueryAll301() {//1�����Բ�ѯ���е����˵��ķ���
		List<Menu301> mList=ims301.queryAll301();//����ims301�Ĳ�ѯ���е����˵��ķ���
		//Assert���ԣ���һ���������������ݿ�������ݵĸ����������Լ������ݿ����д
		//mList.size()��������ֵ���Ǿ���ims301.queryAll301()�����ѯ�����������ݿ���в�ѯ������ʵ������
		Assert.assertEquals(8, mList.size());//��һ���������������ݿ��еĸ���
	}

	@Test
	void testQueryByCond301() {//2�����Դ�������ģ����ѯ�ķ���
		List<Menu301> mList=ims301.queryByCond301("����");//����ims301��������ѯ�����˵��ķ���
		Assert.assertEquals(2, mList.size());//����
		
	}

	@Test
	void testQuery301() {//3�����Ը���id��׼��ѯ�ķ���
		Menu301 menu301=new Menu301();
		menu301.setId301(1);
		menu301=ims301.query301(menu301);
		Assert.assertEquals("��ҳ",menu301.getMenuName301());
	}

	@Test
	void testAdd301() {//4.�������
		Menu301 menu301=new Menu301();
		menu301.setMenuName301("Demo11");
		menu301.setMenuURL301("Demo.jsp11");
		menu301.setMenuNo301("11");
		int flag=ims301.add301(menu301);
		ims301.queryAll301();
		Assert.assertEquals(1,flag);
		
	}

	@Test
	void testUpdate301() {//5�����Ը���
		Menu301 menu301=new Menu301();
		menu301.setMenuName301("Demo6666666");
		menu301.setMenuURL301("Demo.jsp6666666");
		menu301.setMenuNo301("6666666");
		menu301.setId301(9);
		int flag=ims301.update301(menu301);
		ims301.queryAll301();
		Assert.assertEquals(1,flag);
		
		
	}

	@Test
	void testDelete301() {//6������ɾ��
		 Menu301 menu301 = new Menu301();
		    menu301.setId301(9);//10�����ݿ���д��ڵ�����
		    int flag = ims301.delete301(menu301);
		    ims301.queryAll301();
		    Assert.assertEquals(1, flag);
		
	}

}
