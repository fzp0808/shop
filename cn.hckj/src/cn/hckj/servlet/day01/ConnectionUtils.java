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
	//一旦该类被夹在就运行static代码块，里面的内容有且只加载一次，获取数据及加载驱动
	static{
		try {
			getParam();//获取数据
			Class.forName(driver);//加载驱动
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//连接数据库
	//加载完驱动后，来通过加载驱动的drivermananger对象以及获取到的数据来连接数据库，
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	//获取到里面的四个数据
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
