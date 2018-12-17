package student.day05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/filter.do")
public class FilterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String input=(String) req.getAttribute("text");
//		PrintWriter pw=resp.getWriter();
//		pw.print(input);
		req.setAttribute("text1", input);
		req.getRequestDispatcher("filter.jsp").forward(req, resp);
	}

}
