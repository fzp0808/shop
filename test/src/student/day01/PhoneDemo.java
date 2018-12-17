package student.day01;

import java.io.IOException;
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

import com.alibaba.fastjson.JSON;
@WebServlet(value="/phone.do")
public class PhoneDemo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
				String sql = "select * from phone";
				ArrayList<Phone> list = new ArrayList<Phone>();
				try {
					conn = ConnectionUtils.getConnection();
					psmt = conn.prepareStatement(sql);
					rs = psmt.executeQuery();
					while(rs.next()) {
						Phone s = new Phone();
						s.setPname(rs.getString(1));
						s.setOne(rs.getInt(2));
						list.add(s);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String jsonStr = JSON.toJSON(list).toString();
				System.out.println(jsonStr);
				//5、数据发给前台
				resp.getWriter().write(jsonStr);
			}
	}


