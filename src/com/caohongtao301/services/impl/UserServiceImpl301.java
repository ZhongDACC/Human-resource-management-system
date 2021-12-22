package com.caohongtao301.services.impl;

import java.util.List;
import java.util.Map;

import com.caohongtao301.dao.IUserDao301;
import com.caohongtao301.dao.impl.UserDaoImpl301;
import com.caohongtao301.pojo.User301;
import com.caohongtao301.services.IUserService301;

/** 
* @ClassName: UserServiceImpl301 
* @Description: TODO(other) 
* @author ²ÜºéÌÎ
* @date 2021-11-28 20:23:09 
*  
*/
public class UserServiceImpl301 implements IUserService301 {

	IUserDao301 iud301=new UserDaoImpl301();
	@Override
	public List<User301> findAll() {
		// TODO Auto-generated method stub
		return iud301.findAll();
	}

	@Override
	public User301 findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return iud301.findUserByUsernameAndPassword(username, password);
	}

	@Override
	public void add(User301 user) {
		// TODO Auto-generated method stub
		iud301.add(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		iud301.delete(id);
	}

	@Override
	public User301 findById(int i) {
		// TODO Auto-generated method stub
		return iud301.findById(i);
	}

	@Override
	public void update(User301 user) {
		// TODO Auto-generated method stub
		iud301.update(user);
	}

	@Override
	public int findTotalCount(Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		return iud301.findTotalCount(condition);
	}

	@Override
	public List<User301> findByPage(int start, int rows, Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		return iud301.findByPage(start, rows, condition);
	}

}
