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
* @author �ܺ���
* @date 2021-11-28 20:19:54 
*  
*/
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMenuService301 ims301 = new MenuServiceImpl301();
	//ICompanyInfomationService301 cis301 = new CompanyInfomationServiceImpl301();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		queryAll(request,response);//���ڲ�ѯ���е����˵���Ϣ
		//��ѯ�������
		//��ѯXXXX
		//��ѯXXXX
		//������ӣ����� �����ݿ���е�
		//��ѯ���������ݿ���е�����  ��  ҳ��
		//������Щҳ�棬��������Щ�࣬˳����ʲô
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * ��ѯ������Ϣ�ķ���
	 * @param request ����
	 * @param response ��Ӧ
	 * @throws ServletException Servlet�쳣
	 * @throws IOException IO�쳣
	 */
	protected void queryAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Menu301> menusList = ims301.queryAll301();// ���÷����ӿ�ʵ����Ĳ�ѯ���з���
		request.getSession().setAttribute("menus", menusList);// �Ѳ�ѯ�����ĵ����˵����ݼ��Ϸŵ�session����
		//request.setAttribute("menus", menusList);// �Ѳ�ѯ�����ĵ����˵����ݼ��Ϸŵ�request����
		//List<CompanyInfomation301> ciList = cis301.queryAll301();// ���÷����ӿ�ʵ����Ĳ�ѯ���з���
		//request.getSession().setAttribute("ciList", ciList);// �Ѳ�ѯ�����ĵ����˵����ݼ��Ϸŵ�request����
		
		request.getRequestDispatcher("index.jsp").forward(request, response);// ת����index.jspҳ����ȥ
	}


}
