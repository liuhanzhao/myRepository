 package cn.tedu.store.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * HTML访问过滤器
 */

public class HtmlAccessFilter implements Filter{
	/*
	 * 白名单，允许直接访问的页面列表
	 */
	private List<String> whiteList=new ArrayList<String>();
	
	
	public void init(FilterConfig arg0) throws ServletException {
	/*
	 * 初始化白名单
	 *	   
	 */
	whiteList.add("register.html");
	whiteList.add("login.html");
	whiteList.add("footerTemplate.html");
	whiteList.add("topTemplate.html");
	whiteList.add("leftTemplate.html");
	whiteList.add("index.html");

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) arg0;
        String uri=request.getRequestURI();                 
        System.out.println("当前请求："+uri);
        int beginIndex=uri.lastIndexOf("/")+1;
        String filename=uri.substring(beginIndex);
        System.out.println("当前请求路径："+filename);
        if(whiteList.contains(filename)) {
        	//放行
        	System.out.println("无需验证,过滤器放行");
        	 arg2.doFilter(arg0, arg1);
        }else {
        	System.out.println("需要session验证,被过滤器验证");
        	HttpSession session=request.getSession();
        	if(session.getAttribute("uid")!=null) {
        		System.out.println("有session,放行!");
        		arg2.doFilter(arg0, arg1);
        	}else {
        		HttpServletResponse response=(HttpServletResponse) arg1;
        		String url=request.getContextPath();
        		System.out.println("url:"+url);
        		response.sendRedirect(url+"/web/login.html");
        	}
        }
        
       
		
		
	}



}
