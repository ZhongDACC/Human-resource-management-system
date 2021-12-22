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
* @author �ܺ���
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
		
		//0.ǿ��ת��
        HttpServletRequest request = (HttpServletRequest) req;

        //1.��ȡ��Դ����·��
        String uri = request.getRequestURI();
        //2.�ж��Ƿ������¼�����Դ·��,Ҫע���ų��� css/js/ͼƬ/��֤�����Դ
        if(uri.contains("/login.jsp") || uri.contains("/LoginServlet301") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/CheckCode301") 
		/* || uri.contains("/IndexServlet") */){
            //�������û��������¼������
            chain.doFilter(req, resp);
        }else{
            //����������Ҫ��֤�û��Ƿ��¼
            //3.�ӻ�ȡsession�л�ȡuser
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                //��¼�ˡ�����
                chain.doFilter(req, resp);
            }else{
                //û�е�¼����ת��¼ҳ��

                request.setAttribute("login_msg","����δ��¼�����¼");
                request.getRequestDispatcher("/Manager/Login.jsp").forward(request,resp);
            }
        }


        // chain.doFilter(req, resp);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
