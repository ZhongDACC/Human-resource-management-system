package com.caohongtao301.services;

import java.util.List;
import java.util.Map;

import com.caohongtao301.pojo.User301;


/** 
* @ClassName: IUserService301 
* @Description: TODO(other) 
* @author �ܺ���
* @date 2021-11-28 20:22:49 
*  
*/
public interface IUserService301 {

	public List<User301> findAll();//��ѯ����

    User301 findUserByUsernameAndPassword(String username, String password);//�û���¼��֤

    void add(User301 user);//��ӷ���

    void delete(int id);//ɾ������

    User301 findById(int i);//������Ų�ѯ

    void update(User301 user);//����

    /**
     * ��ѯ�ܼ�¼��
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * ��ҳ��ѯÿҳ��¼
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User301> findByPage(int start, int rows, Map<String, String[]> condition);
}
