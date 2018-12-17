package cn.hckj.servlet.day04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/testlogin.do")
public class RemomberPasswordDemo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String remember=req.getParameter("remember");
		if("on".equals(remember)){
			Cookie cookie=new Cookie(username, password);
			resp.addCookie(cookie);
		
		}
	}

}
