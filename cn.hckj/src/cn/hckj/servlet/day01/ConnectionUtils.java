package cn.hckj.servlet.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public  class ConnectionUtils {
	static String username;
	static String password;
	static String url;
	static String driver;
	//һ�����౻���ھ�����static����飬�������������ֻ����һ�Σ���ȡ���ݼ���������
	static{
		try {
			getParam();//��ȡ����
			Class.forName(driver);//��������
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//�������ݿ�
	//��������������ͨ������������drivermananger�����Լ���ȡ�����������������ݿ⣬
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	//��ȡ��������ĸ�����
	public static void getParam() throws FileNotFoundException, IOException{
		Properties prop=new Properties();
		prop.load(new FileInputStream(new File("src/db_oracle.properties")));
		username=prop.getProperty("username");
		password=prop.getProperty("password");
		url=prop.getProperty("url");
		driver=prop.getProperty("driver");
	}
	public static void main(String[] args) throws SQLException {
		getConnection();
	}
	public static void closeResource(Connection conn, PreparedStatement psmt,
			ResultSet rs) {
		if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(psmt!=null){
		try {
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
}
