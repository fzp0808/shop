package cn.hckj.servlet.day04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/cook.do")
public class AddCookie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		Cookie [] cookies=req.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				System.out.println("name:"+cookie.getName()+",value:"+cookie.getValue());
			}
		}else{
			Cookie ck =new Cookie("uname","ÕÅÈý");
			ck.setMaxAge(50);
			resp.addCookie(ck);
			pw.println("cookie add successfull!");
		}
	}

}
