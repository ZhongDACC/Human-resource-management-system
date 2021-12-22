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
* @author 曹洪涛
* @date 2021-11-28 20:23:27 
*  
*/
class MenuServiceImplTest301 {

	/*
	 * @BeforeAll static void setUpBeforeClass() throws Exception { }
	 * 
	 * @AfterAll static void tearDownAfterClass() throws Exception { }
	 */

    //声明IMenuService301接口类型变量ims301，ims301是实现类MenuServiceImpl301的具体实例
	IMenuService301 ims301=new MenuServiceImpl301();
	@Test
	void testQueryAll301() {//1、测试查询所有导航菜单的方法
		List<Menu301> mList=ims301.queryAll301();//调用ims301的查询所有导航菜单的方法
		//Assert断言，第一个参数是我们数据库表中数据的个数，根据自己的数据库表填写
		//mList.size()方法返回值就是经过ims301.queryAll301()这个查询方法，从数据库表中查询出来的实际数据
		Assert.assertEquals(8, mList.size());//第一个参数，代表数据库中的个数
	}

	@Test
	void testQueryByCond301() {//2、测试带有条件模糊查询的方法
		List<Menu301> mList=ims301.queryByCond301("中心");//调用ims301的条件查询导航菜单的方法
		Assert.assertEquals(2, mList.size());//断言
		
	}

	@Test
	void testQuery301() {//3、测试根据id精准查询的方法
		Menu301 menu301=new Menu301();
		menu301.setId301(1);
		menu301=ims301.query301(menu301);
		Assert.assertEquals("首页",menu301.getMenuName301());
	}

	@Test
	void testAdd301() {//4.测试添加
		Menu301 menu301=new Menu301();
		menu301.setMenuName301("Demo11");
		menu301.setMenuURL301("Demo.jsp11");
		menu301.setMenuNo301("11");
		int flag=ims301.add301(menu301);
		ims301.queryAll301();
		Assert.assertEquals(1,flag);
		
	}

	@Test
	void testUpdate301() {//5、测试更新
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
	void testDelete301() {//6、测试删除
		 Menu301 menu301 = new Menu301();
		    menu301.setId301(9);//10是数据库表中存在的数据
		    int flag = ims301.delete301(menu301);
		    ims301.queryAll301();
		    Assert.assertEquals(1, flag);
		
	}

}
