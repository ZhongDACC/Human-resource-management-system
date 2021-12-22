package com.caohongtao301.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohongtao301.pojo.CompanyInfomation301;
import com.caohongtao301.services.ICompanyInfomationService301;
import com.caohongtao301.services.impl.CompanyInfomationServiceImpl301;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: CompanyInfomationController301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:19:16 
*  
*/
@WebServlet("/companyInfoController301")
public class CompanyInfomationController301 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICompanyInfomationService301 cis301 = new CompanyInfomationServiceImpl301();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		//method��ȡֵ��editCompanyInfo��deleteCompanyInfo��addCompanyInfo��updateCompanyInfo��queryByCon
		CompanyInfomation301 ci301 = new CompanyInfomation301();
		System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"  "+"��������");
		if("addCompanyInfo".equalsIgnoreCase(method)) {//��ӵ����˵���Ϣ����
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+"�������� ");
			ci301.setCiNo301(Integer.parseInt(request.getParameter("ciNo301")));
			ci301.setCiTitle301(request.getParameter("ciTitle301"));
			ci301.setCiImage301(request.getParameter("ciImage301"));
			ci301.setCiContent301(request.getParameter("ciContent301"));
			ci301.setCiEditDate301(request.getParameter("ciEditDate301"));
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+" ci301 "+ci301);
			int flag = cis301.add301(ci301);
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+" ci301 "
			+ci301+"����ִ��cis301.add301����֮�� flag="+flag);
			queryAll(request,response);//��ѯ����
		}else if("editCompanyInfo".equalsIgnoreCase(method)){
			String ciId301 = request.getParameter("ciId301");
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+"��ciId301="+ciId301);
			ci301.setCiId301(Integer.parseInt(ciId301));
			ci301 = cis301.query301(ci301);
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if query301()����"+"��ci301="+ci301);
			request.setAttribute("ci301", ci301);
			request.getRequestDispatcher("/WEB-INF/companyinfomanager/EditCompanyInfo301.jsp").forward(request, response);// ת����EditMenu.jspҳ����ȥ
		}else if("updateCompanyInfo".equalsIgnoreCase(method)){
			String ciId301 = request.getParameter("ciId301");
			ci301.setCiId301(Integer.parseInt(ciId301));
			ci301.setCiNo301(Integer.parseInt(request.getParameter("ciNo301")));
			ci301.setCiTitle301(request.getParameter("ciTitle301"));
			ci301.setCiImage301(request.getParameter("ciImage301"));
			ci301.setCiContent301(request.getParameter("ciContent301"));
			ci301.setCiEditDate301(request.getParameter("ciEditDate301"));
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+" ci301 "+ci301);
			int flag = cis301.update301(ci301);
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+" ci301 "
					+ci301+"����ִ��cis301.update301����֮�� flag="+flag);
			queryAll(request,response);//��ѯ����
		}else if("deleteCompanyInfo".equalsIgnoreCase(method)){
			String ciId301 = request.getParameter("ciId301");
			ci301.setCiId301(Integer.parseInt(ciId301));
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+"��ciId301="+ciId301);
			int flag = cis301.delete301(ci301);
			System.out.println("��ǰ��������CompanyInfomationController301��ִ��"+method+"if"+" ci301 "
					+ci301+"����ִ��cis301.delete301����֮�� flag="+flag);
			queryAll(request,response);//��ѯ����
		}else if("queryByCon".equalsIgnoreCase(method)){
			
		}else {
			queryAll(request,response);//��ѯ����
		}
	}
	protected void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CompanyInfomation301> ciList = cis301.queryAll301();// ���÷����ӿ�ʵ����Ĳ�ѯ���з���
		request.getSession().setAttribute("ciList", ciList);// �Ѳ�ѯ�����ĵ����˵����ݼ��Ϸŵ�request����
		request.getRequestDispatcher("/WEB-INF/companyinfomanager/CompanyInfoMain301.jsp").forward(request, response);// ת����main.jspҳ����ȥ
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}