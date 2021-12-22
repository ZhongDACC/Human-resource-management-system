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
* @author �ܺ���
* @date 2021-11-28 20:20:16 
*  
*/
@WebServlet("/MenuServlet301")
public class MenuServlet301 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       IMenuService301 ims301=new MenuServiceImpl301();
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		//method��ȡֵ����������
		//editMenu
		//deleteMenu
		//addMenu
		//updateMenu
		//quertAllMenu
		Menu301 menu301=new Menu301();
		System.out.println("��ǰ����:"+method+"MenuServlet301"+"-ִ��");
		if("addMenu".equalsIgnoreCase(method)) {//���
			String menuNo301=request.getParameter("menNo301");//��ȡAddmenu.jsp����˵���ŵ�������ֵ
			String menuName301=request.getParameter("menuName301");//��ȡaddmenu.jsp����˵����Ƶ�������ֵ
			String menuURL301=request.getParameter("menuURL301");//��ȡaddmenu.jsp����˵���ַ��������ֵ
			menu301.setMenuNo301(menuNo301);//��menu301������menuno301����ֵ��menuNo301���������ֵ��
			menu301.setMenuName301(menuName301);//��menu301������menuname301����ֵ��menuname301���������ֵ��
			menu301.setMenuURL301(menuURL301);//��menu301������menuURL301����ֵ��menuURL301���������ֵ��
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧addMenu"+menu301+"-ִ��");
			//���÷����ӿ�ʵ�������ӷ�������AddMenu.jsp�����ȡ��������ӵ����ݿ���
			ims301.add301(menu301);
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧addMenu"+menu301+"-ִ��ims.add301()֮��");
			//����������֮��ֱ����ת����ѯ���еĽ��棬�������ٿ���֮��ת�����������Ҫ��ҳ
			queryAll(request,response);
		}else if("editMenu".equalsIgnoreCase(method)) {//�༭
			String id301=request.getParameter("id301");//��ȡmain.jsp����˵���ŵ�ֵ
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧editMenu"+id301+"-ִ��");
			menu301.setId301(Integer.parseInt(id301));//Integer.parseInt(id301)ʹ��Integer���parseint��������id301�ַ�����ʽ��ֵ��ת��Ϊint����
			menu301 =ims301.query301(menu301);//���ݵ��main.jspҳ��ı༭��ȡ�˵��ı�ţ�ȥ���ݿ���в�ѯ����˵���Ϣ
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧editMenu"+menu301+"-ִ��ims.query301()֮��");
			request.setAttribute("menu", menu301);//�����ݿ�
			request.getRequestDispatcher("EditMenu301.jsp").forward(request, response);
		}else if("deleteMenu".equalsIgnoreCase(method)) {//ɾ��
			String id301=request.getParameter("id301");
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧deleteMenu"+id301+"-ִ��");
			menu301.setId301(Integer.parseInt(id301));
			int flag =ims301.delete301(menu301);
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧deleteMenu"+menu301+"-ִ��ims.delete301()֮��");
			queryAll(request,response);
		}else if("updateMenu".equalsIgnoreCase(method)) {//�༭
			String id301=request.getParameter("id301");//��ȡmain.jsp����˵���ŵ�ֵ
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧editMenu"+id301+"-ִ��");
			menu301.setId301(Integer.parseInt(id301));//Integer.parseInt(id301)ʹ��Integer���parseint��������id301�ַ�����ʽ��ֵ��ת��Ϊint����
			String menuNo301=request.getParameter("menuNo301");
			String menuName301=request.getParameter("menuName301");
			String menuURL301=request.getParameter("menuURL301");
			menu301.setMenuNo301(menuNo301);//��menu301������menuno301����ֵ��menuNo301���������ֵ��
			menu301.setMenuName301(menuName301);//��menu301������menuname301����ֵ��menuname301���������ֵ��
			menu301.setMenuURL301(menuURL301);
			
			System.out.println("��ǰ����:"+method+"MenuServlet301"+"if��֧editMenu"+menu301+"-ִ��ims.query301()֮��");
			int flag=ims301.update301(menu301);
			
			queryAll(request,response);
		}else if("queryAllMenu".equalsIgnoreCase(method)) {//��ѯ����
			queryAll(request,response);
		}else {//��ѯ����
			queryAll(request,response);
		}
	}
		
		
	/**
	 * ��ѯ���е�����Ϣ�ķ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	protected void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu301> menusList=ims301.queryAll301();//���÷����ӿ�ʵ����Ĳ�ѯ���з���
		request.setAttribute("menus", menusList);//�Ѳ�ѯ���������ݼ��Ϸŵ�request����
		request.getRequestDispatcher("main.jsp").forward(request, response);//ת����main.jspҳ����ȥ
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
