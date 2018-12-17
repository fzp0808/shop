package cn.hckj.servlet.day04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/delete.do")
public class DeleteCookie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		Cookie [] cookies=req.getCookies();
		if(cookies!=null){
			
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("name")&&cookie.getValue().equals("__guid"));
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
		else{
			pw.print("no cookie!");
		}
	}

}
