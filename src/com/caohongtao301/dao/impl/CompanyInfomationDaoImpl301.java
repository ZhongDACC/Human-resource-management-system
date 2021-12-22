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
* @author �ܺ���
* @date 2021-11-28 20:21:23 
*  
*/
public class CompanyInfomationDaoImpl301 implements ICompanyInfomationDao301 {
	/**
	 * 1.��ӹ�˾��Ϣ�ķ���
	 * @param ci301���������������һ����˾��Ϣ����
	 * @return flag����ִ�в��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
	 */
	@Override
	public int add301(CompanyInfomation301 ci301) {
		Connection con = DBConnection301.getConn301();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO  t_companyinfo301 (ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301) VALUES (?,?,?,?,?)";
		int flag = 0;//flag����ִ�в��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ci301.getCiTitle301());
			pstmt.setString(2, ci301.getCiImage301());
			pstmt.setString(3, ci301.getCiContent301());
			pstmt.setString(4, ci301.getCiEditDate301());
			pstmt.setInt(5, ci301.getCiNo301());
			flag = pstmt.executeUpdate();// ִ����Ӳ���
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, null);
		}
		return flag;
	}
	/**
	 * 2.��ѯ���й�˾��Ϣ�ķ���
	 * @return ciList����ִ�в�ѯ�󣬻�õ����в�������ļ���
	 */
	@Override
	public List<CompanyInfomation301> queryAll301() {
		// ��ѯ������Ϣ�ķ���
		List<CompanyInfomation301> ciList = new ArrayList<CompanyInfomation301>();// �������϶���
		Connection con = DBConnection301.getConn301();// ��ȡ���ݿ�����
		PreparedStatement pstmt = null;// ����һ��Ԥ�������
		ResultSet rs = null;// ����һ�����������
		String sql = "select ciId301,ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301 from t_companyinfo301";// ��ѯ���е�sql���
		try {
			pstmt = con.prepareStatement(sql);// ��Ԥ���������ֵ��ͬʱ��sql��䴫��Ԥ���������д���
			rs = pstmt.executeQuery();// ִ�в�ѯ���������ҰѲ�ѯ���������н�����浽�����rs����
			while (rs.next()) {// �ӽ����rs������б����������������ݣ�
				// �ӽ�����л�ȡ���ݣ�Ȼ����һ���˵�����
				CompanyInfomation301 ci301 = new CompanyInfomation301(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6));
				System.out.println(ci301);// ��ӡ�������
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
	 * 3.���ݱ������ģ����ѯ��˾��Ϣ�ķ���
	 * @param condition301���������������һ����˾��Ϣ�ı��⣩
	 * @return ciList����ִ��ģ����ѯ�󣬻�õ����в�������ļ���
	 */
	@Override
	public List<CompanyInfomation301> queryByCond301(String condition301) {
		// ��ѯ����������������Ϣ�ķ���
		List<CompanyInfomation301> ciList = new ArrayList<CompanyInfomation301>();// �������϶���
		Connection con = DBConnection301.getConn301();// ��ȡ���ݿ�����
		PreparedStatement pstmt = null;// ����һ��Ԥ�������
		ResultSet rs = null;// ����һ�����������
		String sql = "select ciId301,ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301 from t_companyinfo301 where ciTitle301 like ?";// ��ѯ���е�sql���
		try {
			pstmt = con.prepareStatement(sql);// ��Ԥ���������ֵ��ͬʱ��sql��䴫��Ԥ���������д���
			pstmt.setString(1, "%"+condition301+"%");
			rs = pstmt.executeQuery();// ִ�в�ѯ���������ҰѲ�ѯ���������н�����浽�����rs����
			while (rs.next()) {// �ӽ����rs������б����������������ݣ�
				// �ӽ�����л�ȡ���ݣ�Ȼ����һ���˵�����
				CompanyInfomation301 ci301 = new CompanyInfomation301(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6));
				System.out.println(ci301);// ��ӡ�������
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
	 * 4.���ݱ�Ž��о�׼��ѯ��˾��Ϣ�ķ���
	 * @param ci301���������������һ����˾��Ϣ��
	 * @return cif301����ִ�о�׼��ѯ�󣬻�õĹ�˾��Ϣ����
	 */
	@Override
	public CompanyInfomation301 query301(CompanyInfomation301 ci301) {
		// ��ѯ������Ϣ�ķ���
		CompanyInfomation301 cif301 = null;
		Connection con = DBConnection301.getConn301();// ��ȡ���ݿ�����
		PreparedStatement pstmt = null;// ����һ��Ԥ�������
		ResultSet rs = null;// ����һ�����������
		String sql = "select ciId301,ciTitle301,ciImage301,ciContent301,ciEditDate301,ciNo301 from t_companyinfo301 where ciId301 = ?";// ��ѯ���е�sql���
		try {
			pstmt = con.prepareStatement(sql);// ��Ԥ���������ֵ��ͬʱ��sql��䴫��Ԥ���������д���
			pstmt.setInt(1, ci301.getCiId301());
			rs = pstmt.executeQuery();// ִ�в�ѯ���������ҰѲ�ѯ���������н�����浽�����rs����
			while (rs.next()) {// �ӽ����rs������б����������������ݣ�
				// �ӽ�����л�ȡ���ݣ�Ȼ����һ���˵�����
				 cif301 = new CompanyInfomation301(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6));
				System.out.println("ci301="+cif301);// ��ӡ�������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, rs);
		}
		return cif301;
	}

	/**
	 * 5.���ݱ�Ÿ��¹�˾��Ϣ�ķ���
	 * @param ci301���������������һ����˾��Ϣ��
	 * @return flag����ִ�и��²��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
	 */
	@Override
	public int update301(CompanyInfomation301 ci301) {
		Connection con = DBConnection301.getConn301();
		PreparedStatement pstmt = null;
		String sql = "UPDATE t_companyinfo301 SET ciTitle301 = ?, ciImage301 = ?, ciContent301 = ? ,ciEditDate301 = ?,ciNo301=? where ciId301= ?";
		int flag = 0;//flag����ִ�в��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ci301.getCiTitle301());
			pstmt.setString(2, ci301.getCiImage301());
			pstmt.setString(3, ci301.getCiContent301());
			pstmt.setString(4, ci301.getCiEditDate301());
			pstmt.setInt(5,ci301.getCiNo301());
			pstmt.setInt(6,ci301.getCiId301());
			flag = pstmt.executeUpdate();// ִ�и��²���
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, null);
		}
		return flag;
	
	}
	/**
	 * 6.���ݱ��ɾ����˾��Ϣ�ķ���
	 * @param ci301���������������һ����˾��Ϣ��
	 * @return flag����ִ��ɾ�����������0����ִ��ʧ�ܣ�1����ִ�гɹ���
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
			i = pstmt.executeUpdate();// ִ��ɾ������
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection301.close(con, null, pstmt, null);
		}
		return i;
	}
}