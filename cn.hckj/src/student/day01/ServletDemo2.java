package student.day01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet{
	ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("���ó�ʼ������");
		this.config=config;
	}
	public ServletDemo2(){
		System.out.println("����Demo2����");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("����Demo2����");
		System.out.println(config.getInitParameter("username"));
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("����destroy");
	}
	
}
