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

import cn.hckj.servlet.day03.ConnectionUtils;
@WebServlet(value="/login1.do")
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
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
				ArrayList<PRODUCT> list=findAll();
				System.out.println("��½�ɹ�");
				HttpSession session=req.getSession();
				session.setAttribute("name", list);
				req.getRequestDispatcher("list.jsp").forward(req, resp);	
			}else{
				req.setAttribute("error_msg", "�û����������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<PRODUCT> findAll() throws SQLException{
		ArrayList<PRODUCT> list = new ArrayList<PRODUCT>();
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select id,p_name,description,price,p_pic from t_product";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()){
			PRODUCT e = new PRODUCT();
			e.setId(rs.getInt(1));
			e.setP_name(rs.getString(2));
			e.setDescription(rs.getString(3));
			e.setPrice(rs.getInt(4));
			e.setP_pic(rs.getString(5));
			list.add(e);
		}
		return list;
	}
	public boolean login(User u) throws SQLException{
		Connection conn = ConnectionUtils.getConnection();
		String sql = "select * from t_user where uname=? and pwd=?";
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
