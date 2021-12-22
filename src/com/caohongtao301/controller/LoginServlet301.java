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
* @author 曹洪涛
* @date 2021-11-28 20:20:07 
*  
*/
@WebServlet("/LoginServlet301")
public class LoginServlet301 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2.获取数据
        //2.1获取用户填写验证码
        String verifycode = request.getParameter("verifycode");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        //3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/Manager/Login.jsp").forward(request,response);

            return;
        }
   
        //4.封装User对象
        User301 user = new User301();
        user.setUsername301(username);
        user.setPassword301(password);
       //5、调用Service查询
        IUserService301 ius301=new UserServiceImpl301();
        User301 loginUser=ius301.findUserByUsernameAndPassword(username, password);

      //6.判断是否登录成功
        if(loginUser != null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/Manager/index301.jsp");//管理后台主界面
        }else{
            //登录失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/Manager/Login.jsp").forward(request,response);

        }



    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
