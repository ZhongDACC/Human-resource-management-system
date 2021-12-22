package com.caohongtao301.utils;

import java.sql.*;

/** 
* @ClassName: DBConnection301 
* @Description: TODO(other) 
* @author ²ÜºéÌÎ
* @date 2021-11-28 20:23:47 
*  
*/
public class DBConnection301 {

	public static Connection getConn301() {
		Connection conn  = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/wms301?user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public static void main(String[] args) {
		getConn301();
	}
	public static void close(Connection con,Statement stmt, PreparedStatement pstmt,ResultSet rs){
		try {
			if(con != null){
				con.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt != null){
				stmt.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt != null){
				pstmt.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs != null){
				rs.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}