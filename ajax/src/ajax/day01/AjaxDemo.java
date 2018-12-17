package ajax.day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/checkUsername.do")
public class AjaxDemo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username=req.getParameter("username");
		PrintWriter pw=resp.getWriter();
		if("fzp".equals(username)){
			pw.write("login in!");
		}else{
			pw.write("login error!");
		}
	}
}
