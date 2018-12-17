package student.day05;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.servlet.jsp.jstl.core.Config;
//@WebFilter(value="*.do",initParams=@WebInitParam(name="illstr",value="Äã"))
public class FilterDemo implements Filter{
	FilterConfig config=null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config=filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String illstr=config.getInitParameter("illstr");
		String input=req.getParameter("text");
		PrintWriter pw =resp.getWriter();
		if(input.indexOf(illstr)>=0){
			input=input.replace("Äã", "X");
			req.setAttribute("text", input);
			chain.doFilter(req, resp);
		}else{
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
		
		
	}

}
