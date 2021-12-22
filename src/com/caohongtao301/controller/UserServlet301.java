package com.caohongtao301.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caohongtao301.pojo.User301;
import com.caohongtao301.services.IUserService301;
import com.caohongtao301.services.impl.UserServiceImpl301;


/** 
* @ClassName: UserServlet301 
* @Description: TODO(other) 
* @author ²ÜºéÌÎ
* @date 2021-11-28 20:20:34 
*  
*/
@WebServlet("/UserServlet301")
public class UserServlet301 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   IUserService301 ius301=new UserServiceImpl301();
 
    public UserServlet301() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		String method=request.getParameter("method");
		User301 user301 =new User301();
		if("addUser".equalsIgnoreCase(method)) {
			user301.setName301(request.getParameter("name")); 
			user301.setGender301(request.getParameter("gender"));
			user301.setAge301(Integer.parseInt(request.getParameter("age")));
			user301.setAddress301(request.getParameter("address"));
			user301.setQq301(request.getParameter("qq"));
			user301.setEmail301(request.getParameter("email"));
			ius301.add(user301);
			
	       
			queryAll(request,response);
		}else if("queryAllUser".equalsIgnoreCase(method)) {
			queryAll(request,response);
		}else if("editUser".equalsIgnoreCase(method)) {
			String id=request.getParameter("id");
			user301=ius301.findById(Integer.parseInt(id));
			request.setAttribute("user", user301);
			
			
			request.getRequestDispatcher("/WEB-INF/UserManager/EditUser301.jsp").forward(request, response);
			
			
			queryAll(request,response);
		}else if("updateUser".equalsIgnoreCase(method)) {
			String id=request.getParameter("id");
			user301.setId301(Integer.parseInt(id));
			user301.setName301(request.getParameter("name"));
			user301.setGender301(request.getParameter("gender"));
			user301.setAge301(Integer.parseInt(request.getParameter("age")));
			user301.setAddress301(request.getParameter("address"));
			user301.setQq301(request.getParameter("qq"));
			user301.setEmail301(request.getParameter("email"));
			ius301.update(user301);
			
			queryAll(request,response);
		}else if("deleteUser".equalsIgnoreCase(method)) {
			String id=request.getParameter("id");
			ius301.delete(Integer.parseInt(id));
			
			queryAll(request,response);
		}else if("addPage".equalsIgnoreCase(method)) {
			request.getRequestDispatcher("/WEB-INF/UserManager/AddUser301.jsp").forward(request, response);
		}else {
			queryAll(request,response);
		}
	}
protected void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User301> uList=ius301.findAll();
		request.getSession().setAttribute("uList",uList);
		request.getRequestDispatcher("/WEB-INF/UserManager/UserMain301.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
