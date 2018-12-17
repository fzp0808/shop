package ajax.day02;

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
@WebServlet(value="/count.do")
public class SalesDemo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ArrayList<Sales> list=null;
		try {
			list=getSales();
			String data=JSON.toJSON(list).toString();
			resp.getWriter().write(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Sales> getSales() throws SQLException{
		ArrayList<Sales> list=new ArrayList<Sales>();
		Connection conn=ConnectionUtils.getConnection();
		String sql="select * from (select t_name,t_price,t_num from t_sales order by t_num desc) where rownum<4";
		PreparedStatement psmt=conn.prepareStatement(sql);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			Sales s=new Sales();
			s.settName(rs.getString(1));
			s.settPrice(rs.getDouble(2));
			s.settNum(rs.getInt(3));
			list.add(s);
		}
		return list;
	}
}
