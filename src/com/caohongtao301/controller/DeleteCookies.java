package com.caohongtao301.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** 
* @ClassName: DeleteCookies 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:19:36 
*  
*/
@WebServlet("/DeleteCookies")
public class DeleteCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // 获取与该域相关的 Cookie 的数组
        cookies = request.getCookies();
        
            // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
   
        PrintWriter out = response.getWriter();
        String title = "删除 Cookie 实例";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                  "<html>\n" +
                  "<head><title>" + title + "</title></head>\n" +
                  "<body bgcolor=\"#f0f0f0\">\n" );
         if( cookies != null ){
           out.println("<h2>Cookie 名称和值</h2>");
           for (int i = 0; i < cookies.length; i++){
              cookie = cookies[i];
              if((cookie.getName( )).compareTo("url") == 0 ){
                   cookie.setMaxAge(0);
                   response.addCookie(cookie);
                   out.print("已删除的 cookie：" + 
                                cookie.getName( ) + "<br/>");
              }
              out.print("名称：" + cookie.getName( ) + "，");
              out.print("值：" + cookie.getValue( )+" <br/>");
           }
        }else{
            out.println(
              "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
        }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}