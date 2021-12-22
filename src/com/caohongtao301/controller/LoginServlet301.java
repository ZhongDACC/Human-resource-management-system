package com.caohongtao301.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caohongtao301.pojo.User301;
import com.caohongtao301.services.IUserService301;
import com.caohongtao301.services.impl.UserServiceImpl301;


/** 
* @ClassName: LoginServlet301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:20:07 
*  
*/
@WebServlet("/LoginServlet301")
public class LoginServlet301 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.��ȡ����
        //2.1��ȡ�û���д��֤��
        String verifycode = request.getParameter("verifycode");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        //3.��֤��У��
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//ȷ����֤��һ����
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //��֤�벻��ȷ
            //��ʾ��Ϣ
            request.setAttribute("login_msg","��֤�����");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/Manager/Login.jsp").forward(request,response);

            return;
        }
   
        //4.��װUser����
        User301 user = new User301();
        user.setUsername301(username);
        user.setPassword301(password);
       //5������Service��ѯ
        IUserService301 ius301=new UserServiceImpl301();
        User301 loginUser=ius301.findUserByUsernameAndPassword(username, password);

      //6.�ж��Ƿ��¼�ɹ�
        if(loginUser != null){
            //��¼�ɹ�
            //���û�����session
            session.setAttribute("user",loginUser);
            //��תҳ��
            response.sendRedirect(request.getContextPath()+"/Manager/index301.jsp");//�����̨������
        }else{
            //��¼ʧ��
            //��ʾ��Ϣ
            request.setAttribute("login_msg","�û������������");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/Manager/Login.jsp").forward(request,response);

        }



    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
