package com.zfsoft.zftal.web.filter;

import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ChenMinming
 * @date 2015-6-26
 * @version V1.0.0
 */
@WebFilter
public class WeChatLoginFilter implements Filter {

	public final static String STATE="LOGIN_BY_WEIXIN";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest requestObj, ServletResponse responseObj,
                         FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		if(requestObj instanceof HttpServletRequest){
			request = (HttpServletRequest)requestObj;
		}
		if(responseObj instanceof HttpServletResponse){
			response = (HttpServletResponse)responseObj;
		}
		String code = request.getParameter("code");
    	String state = request.getParameter("state");
		//转换失败或者state参数不为则不进行处理
        if(!STATE.equals(state)||request==null||response==null){
        	chain.doFilter(requestObj, responseObj);
        	return;
        }

        chain.doFilter(requestObj, responseObj);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
}
