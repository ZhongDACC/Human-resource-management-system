package com.caohongtao301.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import com.caohongtao301.dao.IMenuDao301;
import com.caohongtao301.pojo.Menu301;
import com.caohongtao301.utils.DBConnection301;

/** 
* @ClassName: MenuDaoImpl301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:21:31 
*  
*/
public class MenuDaoImpl301 implements IMenuDao301 {

	@Override
	public List<Menu301> queryAll301() {//查询所有
		List<Menu301> menusList=new ArrayList<Menu301>();//创建导航菜单的集合对象
		Connection con=DBConnection301.getConn301();//获取数据库连接
		PreparedStatement pstmt=null;//声明一个预处理变量
		ResultSet rs=null;//声明一结果集变量
		String sql="select id,menuName,menuURL,menuNo from t_menu";//查询所有菜单信息的sql语句
		try {
			pstmt=con.prepareStatement(sql);//给预处理变量赋值，同时把sql语句传入预处理对象进行处理
			rs=pstmt.executeQuery();//执行查询操作，并且把查询出来的所有结果保存到结果集rs里面
			while(rs.next()) {//从结果集rs里面进行遍历
				Menu301 menu =new Menu301(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
				
                     System.out.println(menu.toString());
                     menusList.add(menu);
			} 
			}catch(SQLException e){
				e.printStackTrace();
		}finally {
			DBConnection301.close(con,null,pstmt,rs);
		}
		return menusList;
	}

	/**
	 * 2.根据条件查询菜单信息
	 * @param condition301(导航菜单的menuName)
	 * @return 满足条件的导航菜单集合mensList
	 */
	@Override
	public List<Menu301> queryByCond301(String condition301) {
		 List<Menu301> menusList = new ArrayList<Menu301>();

		    Connection con = DBConnection301.getConn301();

		    PreparedStatement pstmt = null;

		    ResultSet rs = null;
		    //采用模糊查询

		    String sql = "select id,menuName,menuURl,menuNo from t_menu where menuName like ?";

		    try {

		        pstmt = con.prepareStatement(sql);
		    //条件condition301就是导航菜单的名称，获取菜单的名称关键字，传给sql
		        pstmt.setString(1, "%"+condition301+"%");//调用m的getMenuName()方法,获取菜单的名称关键字，传给sql
		    
		        rs = pstmt.executeQuery();//执行查询方法
		    
		        while (rs.next()) {
		    
		        Menu301 menu = new Menu301(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
		    
		        System.out.println(menu.toString());
		    
		        menusList.add(menu);
		        }
		      } catch (SQLException e) {

		        e.printStackTrace();

		      } finally {

		    DBConnection301.close(con, null, pstmt, rs);

		    }
		    return menusList;
		  }


	/**
	   * 3.精确查询导航菜单信息的方法（根据id查询）
	   * @param menu300（传入参数，传入一个菜单，菜单的id属性要有值）
	   * @return 返回从数据库表中查询出来的菜单信息menu
	   */
	@Override
	public Menu301 query301(Menu301 menu301) {
		

	    // 3.查询菜单信息,根据id查询

	    Menu301 menu = null;

	    Connection con = DBConnection301.getConn301();

	    PreparedStatement pstmt = null;

	    ResultSet rs = null;

	    String sql = "select id,menuName,menuURl,menuNo from t_menu where id = ?";

	    try {

	    pstmt = con.prepareStatement(sql);

	    pstmt.setInt(1, menu301.getId301());// 调用m的getMenuNo()方法,获取菜单的序号，传给sql

	    rs = pstmt.executeQuery();// 执行查询方法

	    while (rs.next()) {

	    menu = new Menu301(rs.getInt(1), rs.getString(2), rs.getString (3),rs.getString(4));
	    
	    System.out.println(menu);
	  

	    }

	    } catch (SQLException e) {

	    e.printStackTrace();

	    } finally {

	    DBConnection301.close(con, null, pstmt, rs);

	    }

	    return menu;



	  }

	
	 /**
	   * 4.添加导航菜单信息的方法
	   * @param menu300（传入参数，传入一个菜单对象）
	   * @return 返回从数据库表中添加成功的菜单对象
	   */
	@Override
	public int add301(Menu301 menu301) {
		 Connection con = DBConnection301.getConn301();
		    PreparedStatement pstmt = null;
		    String sql = "INSERT INTO  t_menu (menuName,menuURl,menuNo) VALUES (?,?,?)";
		    int flag = 0;//flag代表执行操作结果，0代表执行失败，1代表执行成功。
		    try {
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, menu301.getMenuName301());
		      pstmt.setString(2, menu301.getMenuURL301());
		      pstmt.setString(3, menu301.getMenuNo301());
		      flag = pstmt.executeUpdate();// 执行添加操作
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBConnection301.close(con, null, pstmt, null);
		    }
		    return flag;
		  }


	/**
	   * 5.更新导航菜单信息的方法
	   * @param menu300（传入参数，传入一个菜单对象）
	   * @return flag代表执行操作结果，0代表执行失败，1代表执行成功。
	   */

	@Override
	public int update301(Menu301 menu301) {
		 Connection con = DBConnection301.getConn301();
		    PreparedStatement pstmt = null;
		    String sql = "UPDATE t_menu SET menuName = ?, menuURl = ?, menuNo = ?  where id= ?";
		    int flag = 0;//flag代表执行操作结果，0代表执行失败，1代表执行成功。
		    try {
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, menu301.getMenuName301());
		      pstmt.setString(2, menu301.getMenuURL301());
		      pstmt.setString(3, menu301.getMenuNo301());
		      pstmt.setInt(4, menu301.getId301());
		      flag = pstmt.executeUpdate();// 执行更新操作
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBConnection301.close(con, null, pstmt, null);
		    }
		    return flag;
		  }

	
	/**
	   * 6.删除导航菜单信息的方法
	   * @param menu300（传入参数，传入一个菜单对象）
	   * @return flag代表执行操作结果，0代表执行失败，1代表执行成功。
	   */
	@Override
	public int delete301(Menu301 menu301) {
		
		 int i = 0;
		    Connection con = DBConnection301.getConn301();
		    PreparedStatement pstmt = null;
		    String sql = "DELETE FROM t_menu WHERE id = ?";
		    try {
		      pstmt = con.prepareStatement(sql);
		      pstmt.setInt(1, menu301.getId301());
		      i = pstmt.executeUpdate();// 执行删除操作
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBConnection301.close(con, null, pstmt, null);
		    }
		    return i;
		  }
	}


