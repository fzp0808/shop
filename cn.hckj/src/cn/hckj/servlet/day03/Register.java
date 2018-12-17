package cn.hckj.servlet.day03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/register.do")
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2、合并成一个User对象
		T_user u = new T_user();
		u.setUname(username);
		u.setPwd(password);
		try {
			if(!register(u)){
				insert(u);
				req.getRequestDispatcher("center.jsp").forward(req, resp);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean register(T_user u) throws SQLException{
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select * from t_user where uname=? and pwd=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, u.getUname());
		psmt.setString(2, u.getPwd());
		ResultSet rs=psmt.executeQuery();
		if(rs.next()){
			System.out.println("用户名已存在");
		}
		return false;
		
	}
	public void insert(T_user u) throws SQLException{
		Connection conn=ConnectionUtils.getConnection();
		String sql="insert into t_user values(t_user_seq.nextval,?,?)";
		PreparedStatement psmt=conn.prepareStatement(sql);
		psmt.setString(1, u.getUname());
		psmt.setString(2, u.getPwd());
		psmt.executeUpdate();
	}

}
