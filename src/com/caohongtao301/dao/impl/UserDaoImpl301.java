package com.caohongtao301.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import com.caohongtao301.dao.IUserDao301;
import com.caohongtao301.pojo.User301;
import com.caohongtao301.utils.DBConnection301;

/** 
* @ClassName: UserDaoImpl301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:21:40 
*  
*/
public class UserDaoImpl301 implements IUserDao301 {

	@Override
	public List<User301> findAll() {
		List<User301> uList=new ArrayList<User301>();//创建集合对象
		Connection con=DBConnection301.getConn301();//获取数据库连接
		PreparedStatement pstmt=null;//声明一个预处理变量
		ResultSet rs=null;//声明一结果集变量
		String sql="select * from user";//查询所有信息的sql语句
		try {
			pstmt=con.prepareStatement(sql);//给预处理变量赋值，同时把sql语句传入预处理对象进行处理
			rs=pstmt.executeQuery();//执行查询操作，并且把查询出来的所有结果保存到结果集rs里面
			while(rs.next()) {//从结果集rs里面进行遍历
				User301 menu =new User301(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				
                     System.out.println(menu.toString());//打印输出遍历的对象
                     uList.add(menu);//将对象加入到集合对象uList
			} 
			}catch(SQLException e){
				e.printStackTrace();
		}finally {
			DBConnection301.close(con,null,pstmt,rs);
		}
		return uList;
	}

	@Override
	public User301 findUserByUsernameAndPassword(String username, String password) {//根据账号密码进行查询的方法
		 

	    User301 u = null;

	    Connection con = DBConnection301.getConn301();

	    PreparedStatement pstmt = null;

	    ResultSet rs = null;

	    String sql = "select * from user where username = ? and password = ?";

	    try {

	    pstmt = con.prepareStatement(sql);

	    pstmt.setString(1,username);
	    pstmt.setString(2,password);

	    rs = pstmt.executeQuery();// 执行查询方法

	    while (rs.next()) {

	    	u =new User301(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
	    
	    System.out.println(u);
	  

	    }

	    } catch (SQLException e) {

	    e.printStackTrace();

	    } finally {

	    DBConnection301.close(con, null, pstmt, rs);

	    }

	    return u;

	}

	@Override
	public void add(User301 user) {
		Connection con = DBConnection301.getConn301();
	    PreparedStatement pstmt = null;
	    String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
	    int flag = 0;//flag代表执行操作结果，0代表执行失败，1代表执行成功。
	    try {
	      pstmt = con.prepareStatement(sql);
	     pstmt.setString(1,user.getName301());
	     pstmt.setString(2,user.getGender301());
	     pstmt.setInt(3,user.getAge301());
	     pstmt.setString(4,user.getAddress301());
	     pstmt.setString(5,user.getQq301());
	     pstmt.setString(6,user.getEmail301());
	      flag = pstmt.executeUpdate();// 执行添加操作
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      DBConnection301.close(con, null, pstmt, null);
	    }
	    
	  }

	

	@Override
	public void delete(int id) {
		Connection con = DBConnection301.getConn301();
	    PreparedStatement pstmt = null;
	    String sql = "delete from user where id = ?";
	    try {
	      pstmt = con.prepareStatement(sql);
	      pstmt.setInt(1, id);
	       pstmt.executeUpdate();// 执行删除操作
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      DBConnection301.close(con, null, pstmt, null);
	    }
	   

	}

	@Override
	public User301 findById(int id) {
		 User301 u = null;

		    Connection con = DBConnection301.getConn301();

		    PreparedStatement pstmt = null;

		    ResultSet rs = null;

		    String sql = "select * from user where id = ?";

		    try {

		    pstmt = con.prepareStatement(sql);

		   pstmt.setInt(1,id);

		    rs = pstmt.executeQuery();// 执行查询方法

		    while (rs.next()) {

		    	u =new User301(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
		    
		    System.out.println(u);
		  

		    }

		    } catch (SQLException e) {

		    e.printStackTrace();

		    } finally {

		    DBConnection301.close(con, null, pstmt, rs);

		    }

		    return u;
	}

	@Override
	public void update(User301 user) {
		 Connection con = DBConnection301.getConn301();
		    PreparedStatement pstmt = null;
		    String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
		    int flag = 0;//flag代表执行操作结果，0代表执行失败，1代表执行成功。
		    try {
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1,user.getName301());
			     pstmt.setString(2,user.getGender301());
			     pstmt.setInt(3,user.getAge301());
			     pstmt.setString(4,user.getAddress301());
			     pstmt.setString(5,user.getQq301());
			     pstmt.setString(6,user.getEmail301());
			     pstmt.setInt(7, user.getId301());
		       pstmt.executeUpdate();// 执行更新操作
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBConnection301.close(con, null, pstmt, null);
		    }
		  

	}

	@Override
	public int findTotalCount(Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User301> findByPage(int start, int rows, Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
