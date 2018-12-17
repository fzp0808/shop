package cn.hckj.servlet.day03;

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
import javax.servlet.http.HttpSession;
@WebServlet(value="/cart.do")
public class Cart extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String p_name=req.getParameter("p_name");
		Shop s=new Shop();
		s.setP_name(p_name);
		try {
			if(get(s)){
				ArrayList<Shop> list=find();
				HttpSession session=req.getSession();
				session.setAttribute("p_name", list);
				req.getRequestDispatcher("list.jsp").forward(req, resp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<Shop> find() throws SQLException{
		ArrayList<Shop> list =new ArrayList<Shop>();
		Connection conn=ConnectionUtils.getConnection();
		String sql="select id,uname,price from t_product";
		PreparedStatement psmt=conn.prepareStatement(sql);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			Shop s=new Shop();
			s.setId(rs.getInt(1));
			s.setP_name(rs.getString(2));
			s.setPrice(rs.getString(4));
			list.add(s);
		}
		return list;
	}
	
	public boolean get(Shop s) throws SQLException{
		Connection conn=ConnectionUtils.getConnection();
		String sql="select * from t_product where p_name=?";
		PreparedStatement psmt=conn.prepareStatement(sql);
		psmt.setString(1, s.getP_name());
		ResultSet rs=psmt.executeQuery();
		if(rs.next()){
			find();
		}
		return false;
	}

}
