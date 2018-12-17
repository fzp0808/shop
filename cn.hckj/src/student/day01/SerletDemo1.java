package student.day01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SerletDemo1 implements Servlet {
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("调用123");
		this.config=config;
	}
	public SerletDemo1(){
		System.out.println("调用456");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("123");
		System.out.println(config.getInitParameter("username"));
		Enumeration<String> enu=config.getInitParameterNames();
		while(enu.hasMoreElements()){
			String name=enu.nextElement();
			System.out.println(name+","+config.getInitParameter(name));
		}
		ServletContext sc=config.getServletContext();
		System.out.println(sc.getInitParameter("fzp"));
		sc.setAttribute("hehe", "haha");
		
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("调用destroy");
		
	}

}
