package student.day05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/session1.do")
public class Session1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session =req.getSession(false);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(session==null){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else{
			session.invalidate();
		}
	}

}
