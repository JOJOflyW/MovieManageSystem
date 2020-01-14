package cuit.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns = {"/index.jsp","/order.jsp"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
 
        String uri = request.getRequestURI();
        System.out.println(uri);
        
		HttpSession session = request.getSession(false);
		/*
		 * if(session.getAttribute("user")!=null) {
		 * System.out.println("user_session"+session.getAttribute("user"));
		 * chain.doFilter(request, response); }else {
		 * response.sendRedirect("login.jsp"); }
		 */
		
		  if(session==null) { 
			  //System.out.println(session);
			  response.sendRedirect("login.jsp"); 
			  System.out.println("Äã»¹Ã»ÓÐµÇÂ¼"); 
			  
		  }else {
			 chain.doFilter(request, response);
		 	System.out.println(session); 
		  }
		 
		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
