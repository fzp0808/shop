package student.day02;

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
@WebServlet(value="/fenye.action")
public class Fenye extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String data=req.getParameter("name");
		int x=1;
		x+=5;
		try {
			if(("right").equals(data)){
				ArrayList<EMP> list=fenyeb(x, x-4);
				Object obj=JSON.toJSON(list);
				resp.getWriter().write(obj.toString());
			}else if(("left").equals(data)){
				ArrayList<EMP> list=fenyeb(x,x+4);
				Object obj=JSON.toJSON(list);
				resp.getWriter().write(obj.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<EMP> fenyeb(int x,int y) throws SQLException{
		ArrayList<EMP> list=new ArrayList<EMP>();
		Connection conn=ConnectionUtils.getConnection();
		String sql="select * from (select * from "
				+ "(select rownum as rnum,EMPNO from emp) where rnum<=?) where rnum>=?;";
		PreparedStatement psmt=conn.prepareStatement(sql);
		psmt.setInt(1,x);
		psmt.setInt(2,y);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()){
			EMP e=new EMP();
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

}
