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





import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** 
* @ClassName: IndexServlet 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:19:54 
*  
*/
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMenuService301 ims301 = new MenuServiceImpl301();
	//ICompanyInfomationService301 cis301 = new CompanyInfomationServiceImpl301();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		queryAll(request,response);//用于查询所有导航菜单信息
		//查询合作伙伴
		//查询XXXX
		//查询XXXX
		//梳理，添加，数据 到数据库表中的
		//查询，请求，数据库表中的数据  到  页面
		//经过哪些页面，经过了那些类，顺序是什么
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 查询所有信息的方法
	 * @param request 请求
	 * @param response 响应
	 * @throws ServletException Servlet异常
	 * @throws IOException IO异常
	 */
	protected void queryAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Menu301> menusList = ims301.queryAll301();// 调用服务层接口实现类的查询所有方法
		request.getSession().setAttribute("menus", menusList);// 把查询出来的导航菜单数据集合放到session里面
		//request.setAttribute("menus", menusList);// 把查询出来的导航菜单数据集合放到request里面
		//List<CompanyInfomation301> ciList = cis301.queryAll301();// 调用服务层接口实现类的查询所有方法
		//request.getSession().setAttribute("ciList", ciList);// 把查询出来的导航菜单数据集合放到request里面
		
		request.getRequestDispatcher("index.jsp").forward(request, response);// 转发到index.jsp页面上去
	}


}
