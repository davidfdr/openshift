package br.com.infosolo.educa.filter;

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

@WebFilter(urlPatterns="/*")
public class CharsetFilter implements Filter {
	

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	       try {
	          if ((request instanceof HttpServletRequest)
	              && (response instanceof HttpServletResponse))  {
	              request.setCharacterEncoding("UTF-8");
	              response.setContentType("text/html; charset=UTF-8");
	           }
	           chain.doFilter(request, response);
	        } catch (Exception e) {
	           // Do your logging here
	        }
	    }

		@Override
		public void destroy() {
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
		}

}
