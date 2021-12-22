package com.caohongtao301.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.caohongtao301.dao.ICompanyInfomationDao301;
import com.caohongtao301.pojo.CompanyInfomation301;
import com.caohongtao301.utils.DBConnection301;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/** 
* @ClassName: CompanyInfomationDaoImpl301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:21:23 
*  
*/
public class CompanyInfomationDaoImpl301 implements ICompanyInfomationDao301 {
	/**
	 * 1.添加公司信息的方法
	 * @param ci301（传入参数，传入一个公司信息对象）
	 * @return flag代表执行操作结果，0代表执行失败，1代表执行成功。
	 */
	@Override
	public int add301(CompanyInfomation301 ci301) {
		Connection con = DBConnection301.getConn301();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO  t_companyinfo301 (ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301) VALUES (?,?,?,?,?)";
		int flag = 0;//flag代表执行操作结果，0代表执行失败，1代表执行成功。
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ci301.getCiTitle301());
			pstmt.setString(2, ci301.getCiImage301());
			pstmt.setString(3, ci301.getCiContent301());
			pstmt.setString(4, ci301.getCiEditDate301());
			pstmt.setInt(5, ci301.getCiNo301());
			flag = pstmt.executeUpdate();// 执行添加操作
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, null);
		}
		return flag;
	}
	/**
	 * 2.查询所有公司信息的方法
	 * @return ciList代表执行查询后，获得的所有操作结果的集合
	 */
	@Override
	public List<CompanyInfomation301> queryAll301() {
		// 查询所有信息的方法
		List<CompanyInfomation301> ciList = new ArrayList<CompanyInfomation301>();// 创建集合对象
		Connection con = DBConnection301.getConn301();// 获取数据库连接
		PreparedStatement pstmt = null;// 声明一个预处理变量
		ResultSet rs = null;// 声明一个结果集变量
		String sql = "select ciId301,ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301 from t_companyinfo301";// 查询所有的sql语句
		try {
			pstmt = con.prepareStatement(sql);// 给预处理变量赋值，同时把sql语句传入预处理对象进行处理
			rs = pstmt.executeQuery();// 执行查询操作，并且把查询出来的所有结果保存到结果集rs里面
			while (rs.next()) {// 从结果集rs里面进行遍历（迭代）出数据，
				// 从结果集中获取数据，然后构造一个菜单对象
				CompanyInfomation301 ci301 = new CompanyInfomation301(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6));
				System.out.println(ci301);// 打印输出遍历
				ciList.add(ci301);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, rs);
		}
		return ciList;
	}
	/**
	 * 3.根据标题进行模糊查询公司信息的方法
	 * @param condition301（传入参数，传入一个公司信息的标题）
	 * @return ciList代表执行模糊查询后，获得的所有操作结果的集合
	 */
	@Override
	public List<CompanyInfomation301> queryByCond301(String condition301) {
		// 查询满足条件的所有信息的方法
		List<CompanyInfomation301> ciList = new ArrayList<CompanyInfomation301>();// 创建集合对象
		Connection con = DBConnection301.getConn301();// 获取数据库连接
		PreparedStatement pstmt = null;// 声明一个预处理变量
		ResultSet rs = null;// 声明一个结果集变量
		String sql = "select ciId301,ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301 from t_companyinfo301 where ciTitle301 like ?";// 查询所有的sql语句
		try {
			pstmt = con.prepareStatement(sql);// 给预处理变量赋值，同时把sql语句传入预处理对象进行处理
			pstmt.setString(1, "%"+condition301+"%");
			rs = pstmt.executeQuery();// 执行查询操作，并且把查询出来的所有结果保存到结果集rs里面
			while (rs.next()) {// 从结果集rs里面进行遍历（迭代）出数据，
				// 从结果集中获取数据，然后构造一个菜单对象
				CompanyInfomation301 ci301 = new CompanyInfomation301(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6));
				System.out.println(ci301);// 打印输出遍历
				ciList.add(ci301);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, rs);
		}
		return ciList;
	}
	/**
	 * 4.根据编号进行精准查询公司信息的方法
	 * @param ci301（传入参数，传入一个公司信息）
	 * @return cif301代表执行精准查询后，获得的公司信息对象
	 */
	@Override
	public CompanyInfomation301 query301(CompanyInfomation301 ci301) {
		// 查询所有信息的方法
		CompanyInfomation301 cif301 = null;
		Connection con = DBConnection301.getConn301();// 获取数据库连接
		PreparedStatement pstmt = null;// 声明一个预处理变量
		ResultSet rs = null;// 声明一个结果集变量
		String sql = "select ciId301,ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301 from t_companyinfo301 where ciId301 = ?";// 查询所有的sql语句
		try {
			pstmt = con.prepareStatement(sql);// 给预处理变量赋值，同时把sql语句传入预处理对象进行处理
			pstmt.setInt(1, ci301.getCiId301());
			rs = pstmt.executeQuery();// 执行查询操作，并且把查询出来的所有结果保存到结果集rs里面
			while (rs.next()) {// 从结果集rs里面进行遍历（迭代）出数据，
				// 从结果集中获取数据，然后构造一个菜单对象
				 cif301 = new CompanyInfomation301(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6));
				System.out.println("ci301="+cif301);// 打印输出遍历
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, rs);
		}
		return cif301;
	}

	/**
	 * 5.根据编号更新公司信息的方法
	 * @param ci301（传入参数，传入一个公司信息）
	 * @return flag代表执行更新操作结果，0代表执行失败，1代表执行成功。
	 */
	@Override
	public int update301(CompanyInfomation301 ci301) {
		Connection con = DBConnection301.getConn301();
		PreparedStatement pstmt = null;
		String sql = "UPDATE t_companyinfo301 SET ciTitle301 = ?, ciImage301 = ?, ciContent301 = ? ,ciEditDate301 = ?,ciNo301=? where ciId301= ?";
		int flag = 0;//flag代表执行操作结果，0代表执行失败，1代表执行成功。
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ci301.getCiTitle301());
			pstmt.setString(2, ci301.getCiImage301());
			pstmt.setString(3, ci301.getCiContent301());
			pstmt.setString(4, ci301.getCiEditDate301());
			pstmt.setInt(5,ci301.getCiNo301());
			pstmt.setInt(6,ci301.getCiId301());
			flag = pstmt.executeUpdate();// 执行更新操作
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, null);
		}
		return flag;
	
	}
	/**
	 * 6.根据编号删除公司信息的方法
	 * @param ci301（传入参数，传入一个公司信息）
	 * @return flag代表执行删除操作结果，0代表执行失败，1代表执行成功。
	 */
	@Override
	public int delete301(CompanyInfomation301 ci301) {
		int i = 0;
		Connection con = DBConnection301.getConn301();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM t_companyinfo301 WHERE ciId301 = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ci301.getCiId301());
			i = pstmt.executeUpdate();// 执行删除操作
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, null);
		}
		return i;
	}
}