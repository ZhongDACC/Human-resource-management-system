package com.caohongtao301.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/** 
* @ClassName: CharacterEncodingFilter301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:21:47 
*  
*/
@WebFilter(urlPatterns="/*",initParams= {@WebInitParam(name="CharsetEncoding",value="utf-8")})
public class CharacterEncodingFilter301 implements Filter {
	private static String encoding;//����������ճ�ʼ����ֵ

    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter301() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//�����ַ���������
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//����web.xml�����ļ��л���ע���еĳ�ʼ����
		encoding = fConfig.getInitParameter("CharsetEncoding");
	}

}