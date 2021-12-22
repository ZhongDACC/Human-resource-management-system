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
* @author �ܺ���
* @date 2021-11-28 20:21:31 
*  
*/
public class MenuDaoImpl301 implements IMenuDao301 {

	@Override
	public List<Menu301> queryAll301() {//��ѯ����
		List<Menu301> menusList=new ArrayList<Menu301>();//���������˵��ļ��϶���
		Connection con=DBConnection301.getConn301();//��ȡ���ݿ�����
		PreparedStatement pstmt=null;//����һ��Ԥ�������
		ResultSet rs=null;//����һ���������
		String sql="select id,menuName,menuURL,menuNo from t_menu";//��ѯ���в˵���Ϣ��sql���
		try {
			pstmt=con.prepareStatement(sql);//��Ԥ���������ֵ��ͬʱ��sql��䴫��Ԥ���������д���
			rs=pstmt.executeQuery();//ִ�в�ѯ���������ҰѲ�ѯ���������н�����浽�����rs����
			while(rs.next()) {//�ӽ����rs������б���
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
	 * 2.����������ѯ�˵���Ϣ
	 * @param condition301(�����˵���menuName)
	 * @return ���������ĵ����˵�����mensList
	 */
	@Override
	public List<Menu301> queryByCond301(String condition301) {
		 List<Menu301> menusList = new ArrayList<Menu301>();

		    Connection con = DBConnection301.getConn301();

		    PreparedStatement pstmt = null;

		    ResultSet rs = null;
		    //����ģ����ѯ

		    String sql = "select id,menuName,menuURl,menuNo from t_menu where menuName like ?";

		    try {

		        pstmt = con.prepareStatement(sql);
		    //����condition301���ǵ����˵������ƣ���ȡ�˵������ƹؼ��֣�����sql
		        pstmt.setString(1, "%"+condition301+"%");//����m��getMenuName()����,��ȡ�˵������ƹؼ��֣�����sql
		    
		        rs = pstmt.executeQuery();//ִ�в�ѯ����
		    
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
	   * 3.��ȷ��ѯ�����˵���Ϣ�ķ���������id��ѯ��
	   * @param menu300���������������һ���˵����˵���id����Ҫ��ֵ��
	   * @return ���ش����ݿ���в�ѯ�����Ĳ˵���Ϣmenu
	   */
	@Override
	public Menu301 query301(Menu301 menu301) {
		

	    // 3.��ѯ�˵���Ϣ,����id��ѯ

	    Menu301 menu = null;

	    Connection con = DBConnection301.getConn301();

	    PreparedStatement pstmt = null;

	    ResultSet rs = null;

	    String sql = "select id,menuName,menuURl,menuNo from t_menu where id = ?";

	    try {

	    pstmt = con.prepareStatement(sql);

	    pstmt.setInt(1, menu301.getId301());// ����m��getMenuNo()����,��ȡ�˵�����ţ�����sql

	    rs = pstmt.executeQuery();// ִ�в�ѯ����

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
	   * 4.��ӵ����˵���Ϣ�ķ���
	   * @param menu300���������������һ���˵�����
	   * @return ���ش����ݿ������ӳɹ��Ĳ˵�����
	   */
	@Override
	public int add301(Menu301 menu301) {
		 Connection con = DBConnection301.getConn301();
		    PreparedStatement pstmt = null;
		    String sql = "INSERT INTO  t_menu (menuName,menuURl,menuNo) VALUES (?,?,?)";
		    int flag = 0;//flag����ִ�в��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
		    try {
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, menu301.getMenuName301());
		      pstmt.setString(2, menu301.getMenuURL301());
		      pstmt.setString(3, menu301.getMenuNo301());
		      flag = pstmt.executeUpdate();// ִ����Ӳ���
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBConnection301.close(con, null, pstmt, null);
		    }
		    return flag;
		  }


	/**
	   * 5.���µ����˵���Ϣ�ķ���
	   * @param menu300���������������һ���˵�����
	   * @return flag����ִ�в��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
	   */

	@Override
	public int update301(Menu301 menu301) {
		 Connection con = DBConnection301.getConn301();
		    PreparedStatement pstmt = null;
		    String sql = "UPDATE t_menu SET menuName = ?, menuURl = ?, menuNo = ?  where id= ?";
		    int flag = 0;//flag����ִ�в��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
		    try {
		      pstmt = con.prepareStatement(sql);
		      pstmt.setString(1, menu301.getMenuName301());
		      pstmt.setString(2, menu301.getMenuURL301());
		      pstmt.setString(3, menu301.getMenuNo301());
		      pstmt.setInt(4, menu301.getId301());
		      flag = pstmt.executeUpdate();// ִ�и��²���
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBConnection301.close(con, null, pstmt, null);
		    }
		    return flag;
		  }

	
	/**
	   * 6.ɾ�������˵���Ϣ�ķ���
	   * @param menu300���������������һ���˵�����
	   * @return flag����ִ�в��������0����ִ��ʧ�ܣ�1����ִ�гɹ���
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
		      i = pstmt.executeUpdate();// ִ��ɾ������
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      DBConnection301.close(con, null, pstmt, null);
		    }
		    return i;
		  }
	}


