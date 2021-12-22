package com.caohongtao301.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohongtao301.pojo.Menu301;
import com.caohongtao301.services.IMenuService301;
import com.caohongtao301.services.impl.MenuServiceImpl301;


/** 
* @ClassName: MenuServlet301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:20:16 
*  
*/
@WebServlet("/MenuServlet301")
public class MenuServlet301 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       IMenuService301 ims301=new MenuServiceImpl301();
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		//method的取值有以下五种
		//editMenu
		//deleteMenu
		//addMenu
		//updateMenu
		//quertAllMenu
		Menu301 menu301=new Menu301();
		System.out.println("当前操作:"+method+"MenuServlet301"+"-执行");
		if("addMenu".equalsIgnoreCase(method)) {//添加
			String menuNo301=request.getParameter("menNo301");//获取Addmenu.jsp界面菜单序号的输入框的值
			String menuName301=request.getParameter("menuName301");//获取addmenu.jsp界面菜单名称的输入框的值
			String menuURL301=request.getParameter("menuURL301");//获取addmenu.jsp界面菜单地址的输入框的值
			menu301.setMenuNo301(menuNo301);//给menu301的属性menuno301设置值（menuNo301变量保存的值）
			menu301.setMenuName301(menuName301);//给menu301的属性menuname301设置值（menuname301变量保存的值）
			menu301.setMenuURL301(menuURL301);//给menu301的属性menuURL301设置值（menuURL301变量保存的值）
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支addMenu"+menu301+"-执行");
			//调用服务层接口实现类的添加方法，把AddMenu.jsp界面获取的数据添加到数据库中
			ims301.add301(menu301);
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支addMenu"+menu301+"-执行ims.add301()之后");
			//添加完成数据之后，直接跳转到查询所有的界面，数据量少可以之跳转，数据量多就要分页
			queryAll(request,response);
		}else if("editMenu".equalsIgnoreCase(method)) {//编辑
			String id301=request.getParameter("id301");//获取main.jsp界面菜单编号的值
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支editMenu"+id301+"-执行");
			menu301.setId301(Integer.parseInt(id301));//Integer.parseInt(id301)使用Integer类的parseint方法，把id301字符串形式的值，转换为int类型
			menu301 =ims301.query301(menu301);//根据点击main.jsp页面的编辑获取菜单的编号，去数据库表中查询这个菜单信息
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支editMenu"+menu301+"-执行ims.query301()之后");
			request.setAttribute("menu", menu301);//把数据库
			request.getRequestDispatcher("EditMenu301.jsp").forward(request, response);
		}else if("deleteMenu".equalsIgnoreCase(method)) {//删除
			String id301=request.getParameter("id301");
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支deleteMenu"+id301+"-执行");
			menu301.setId301(Integer.parseInt(id301));
			int flag =ims301.delete301(menu301);
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支deleteMenu"+menu301+"-执行ims.delete301()之后");
			queryAll(request,response);
		}else if("updateMenu".equalsIgnoreCase(method)) {//编辑
			String id301=request.getParameter("id301");//获取main.jsp界面菜单编号的值
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支editMenu"+id301+"-执行");
			menu301.setId301(Integer.parseInt(id301));//Integer.parseInt(id301)使用Integer类的parseint方法，把id301字符串形式的值，转换为int类型
			String menuNo301=request.getParameter("menuNo301");
			String menuName301=request.getParameter("menuName301");
			String menuURL301=request.getParameter("menuURL301");
			menu301.setMenuNo301(menuNo301);//给menu301的属性menuno301设置值（menuNo301变量保存的值）
			menu301.setMenuName301(menuName301);//给menu301的属性menuname301设置值（menuname301变量保存的值）
			menu301.setMenuURL301(menuURL301);
			
			System.out.println("当前操作:"+method+"MenuServlet301"+"if分支editMenu"+menu301+"-执行ims.query301()之后");
			int flag=ims301.update301(menu301);
			
			queryAll(request,response);
		}else if("queryAllMenu".equalsIgnoreCase(method)) {//查询所有
			queryAll(request,response);
		}else {//查询所有
			queryAll(request,response);
		}
	}
		
		
	/**
	 * 查询所有导航信息的方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	protected void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu301> menusList=ims301.queryAll301();//调用服务层接口实现类的查询所有方法
		request.setAttribute("menus", menusList);//把查询出来的数据集合放到request里面
		request.getRequestDispatcher("main.jsp").forward(request, response);//转发到main.jsp页面上去
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
