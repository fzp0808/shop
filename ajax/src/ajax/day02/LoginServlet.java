package ajax.day02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/test.do")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		//1���õ�ҳ�������
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2���ϲ���һ��User����
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		//3��ʵ����һ��dao������ҵ���ָ������
		try {
			if(login(u)){
				ArrayList<EMP> list=findAll();
				System.out.println("��½�ɹ�");
				req.setAttribute("name", list);
				req.getRequestDispatcher("test.jsp").forward(req, resp);
			}else{
				req.getRequestDispatcher("test1.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<EMP> findAll() throws SQLException{
		ArrayList<EMP> list = new ArrayList<EMP>();
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO from emp";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			EMP e = new EMP();
			e.setEMPNO(rs.getInt(1));
			e.setENAME(rs.getString(2));
			e.setJOB(rs.getString(3));
			e.setMGR(rs.getInt(4));
			e.setHIREDATE(rs.getString(5));
			e.setSAL(rs.getDouble(6));
			e.setCOMM(rs.getDouble(7));
			e.setDEPTNO(rs.getInt(8));
			list.add(e);
		}
		return list;
	}
	public boolean login(User u) throws SQLException{
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select * from userser where username=? and pass=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, u.getUsername());
		psmt.setString(2, u.getPassword());
		ResultSet rs = psmt.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
		
	}
}
