package com.muka.marry.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
	
	long refreshTime=0L;
    long accessTime=0L;
    long currentTime=0L;
    
	
	 @Override
	  public void init(FilterConfig config) throws ServletException {
	    
		 System.out.println("SessionFilter init() is invoked.");
	  }
	 
	 @Override
	  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	      throws IOException, ServletException {
		 HttpServletRequest httpRequest = (HttpServletRequest) req;
		 HttpServletResponse httpResponse = (HttpServletResponse) res;
	    
	    System.out.println("MyFilter doFilter() is invoked.");
	    currentTime=System.currentTimeMillis();
	    System.out.println("currentTime:"+currentTime);
	   // accessTime=System.currentTimeMillis();
	    HttpSession  httpSession=httpRequest.getSession();
	    accessTime=httpSession.getCreationTime();
	    System.out.println("accessTime:"+accessTime);
	    refreshTime=httpSession.getLastAccessedTime();
	    System.out.println("refreshTime:"+refreshTime);
	    
	    if(currentTime-refreshTime<=300000){
	    	long time=currentTime-refreshTime;
	    	System.out.println("currentTime-refreshTime:"+time);
	    	 chain.doFilter(req, res);
	    	
	    } else {
	    	System.out.println("logout");
	    	long time2=currentTime-refreshTime;
	    	System.out.println("time2:"+time2);
	    	
	    	httpResponse.sendRedirect("logout");
	    }
	  
	   
	  }

	  @Override
	  public void destroy() {
		  System.out.println("SessionFilter destroy() is invoked.");
	  }
}
