package com.caohongtao301.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.caohongtao301.pojo.User301;
import com.caohongtao301.services.IUserService301;
import com.caohongtao301.services.impl.UserServiceImpl301;

/** 
* @ClassName: UserServiceImplTest301 
* @Description: TODO(other) 
* @author ²ÜºéÌÎ
* @date 2021-11-28 20:23:34 
*  
*/
class UserServiceImplTest301 {
	IUserService301 ius301=new UserServiceImpl301();
	User301 user=new User301();



	@Test
	void testFindAll() {
		List<User301> uList=ius301.findAll();
		Assert.assertEquals(3,uList.size());
	}

	@Test
	void testFindUserByUsernameAndPassword() {
		user=ius301.findUserByUsernameAndPassword("admin", "admin");
		Assert.assertEquals("admin",user.getName301());
	}

	@Test
	void testAdd() {
		user.setName301("3");
		user.setGender301("3");
		user.setAge301(3);
		user.setQq301("33333");
		user.setAddress301("33.com");
		ius301.add(user);
		
	}

	@Test
	void testDelete() {
		ius301.delete(2);
	}

	@Test
	void testFindById() {
		user = ius301.findById(1);
		Assert.assertEquals("admin", user.getName301());
	}

	@Test
	void testUpdate() {
		user.setName301("233");
		user.setGender301("233");
		user.setAge301(2);
		user.setQq301("22222223");
		user.setAddress301("223");
	user.setEmail301("223.com");
	user.setId301(3);
	ius301.update(user);
	}

	@Test
	void testFindTotalCount() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByPage() {
		fail("Not yet implemented");
	}

}
