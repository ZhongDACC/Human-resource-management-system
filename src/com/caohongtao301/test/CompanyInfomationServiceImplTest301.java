package com.caohongtao301.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.caohongtao301.pojo.CompanyInfomation301;
import com.caohongtao301.services.ICompanyInfomationService301;
import com.caohongtao301.services.impl.CompanyInfomationServiceImpl301;

/** 
* @ClassName: CompanyInfomationServiceImplTest301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:23:21 
*  
*/
class CompanyInfomationServiceImplTest301 {
	ICompanyInfomationService301 cis301 = new CompanyInfomationServiceImpl301();
	CompanyInfomation301 ci301 = new CompanyInfomation301();


	
	@Test
	void testQueryAll301() {//��ѯ����
		List<CompanyInfomation301> ciList=cis301.queryAll301();
		 Assert.assertEquals(1,ciList.size());
	}

	@Test
	void testQueryByCond301() {//ģ����ѯ����
		List<CompanyInfomation301> ciList=cis301.queryByCond301("˾");
		Assert.assertEquals(1,ciList.size());//��һ�������������ݿ��м�����Ϣ
	}

	@Test
	void testQuery301() {//��׼��ѯ
		ci301.setCiId301(5);
		CompanyInfomation301 cif301 = cis301.query301(ci301);
		Assert.assertEquals("��˾���", cif301.getCiTitle301());
		
	}

	@Test
	void testAdd301() {//�������
		ci301.setCiNo301(6);
	    ci301.setCiTitle301("��˾���");
	    ci301.setCiContent301("��ױƷ��hu�� zhu��ng p��n����Ϊ��������");
	    ci301.setCiImage301("images/pic8.png");
	    ci301.setCiEditDate301("2021-11-24");
	    int flag = cis301.add301(ci301);
	    Assert.assertEquals(1,flag);
	  }
	

	@Test
	void testUpdate301() {//���Ը���
		ci301.setCiId301(1);
		ci301.setCiTitle301("7");
		ci301.setCiImage301("7");
		ci301.setCiContent301("7");
		ci301.setCiEditDate301("7");
		ci301.setCiNo301(7);
		int flag = cis301.update301(ci301);
		Assert.assertEquals(1, flag);
	}

	@Test
	void testDelete301() {
		ci301.setCiId301(1);
		int flag = cis301.delete301(ci301);
		Assert.assertEquals(1, flag);
	}

}
