package cn.hckj.servlet.day01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SerletTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Enumeration<String> enu=req.getHeaderNames();
		PrintWriter pw=resp.getWriter();
		pw.write("<a href='http://www.baidu.com'>");
		pw.write("in");
		pw.write("</a>");
	}
}
