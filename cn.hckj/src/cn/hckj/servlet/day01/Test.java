package cn.hckj.servlet.day01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
	
	}
	public void login(String name,String pass) throws SQLException{
		Connection con=null;
		PreparedStatement psmt;
		con=ConnectionUtils.getConnection();
		String sql="select username,pass from userser where username=? and pass=?";
		psmt=con.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, pass);
		ResultSet rs=null;
		rs = psmt.executeQuery();
	}
}
