package student.day05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/session.do")
public class Session extends HttpServlet{
	int count=0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession(false);
	
		if(session==null){
			HttpSession session1=req.getSession(true);
		}else{
			count++;
		}
		System.out.println(count);
	}

}
