package com.caohongtao301.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/** 
* @ClassName: LoginFilter301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:21:55 
*  
*/
@WebFilter("/*")
public class LoginFilter301 implements Filter {

   
    public LoginFilter301() {
       
    }


	public void destroy() {
	
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		//0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源路径,要注意排除掉 css/js/图片/验证码等资源
        if(uri.contains("/login.jsp") || uri.contains("/LoginServlet301") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/CheckCode301") 
		/* || uri.contains("/IndexServlet") */){
            //包含，用户就是想登录。放行
            chain.doFilter(req, resp);
        }else{
            //不包含，需要验证用户是否登录
            //3.从获取session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                //登录了。放行
                chain.doFilter(req, resp);
            }else{
                //没有登录。跳转登录页面

                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/Manager/Login.jsp").forward(request,resp);
            }
        }


        // chain.doFilter(req, resp);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
