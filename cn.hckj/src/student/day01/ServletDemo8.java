package student.day01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/redice.do")
public class ServletDemo8 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("index.html");
//		resp.sendRedirect("http://www.baidu.com");
//		req.setAttribute("book", "สýัง");
//		resp.sendRedirect("/to.do");
	}

}
