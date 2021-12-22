package com.caohongtao301.services;

import java.util.List;
import java.util.Map;

import com.caohongtao301.pojo.User301;


/** 
* @ClassName: IUserService301 
* @Description: TODO(other) 
* @author 曹洪涛
* @date 2021-11-28 20:22:49 
*  
*/
public interface IUserService301 {

	public List<User301> findAll();//查询所有

    User301 findUserByUsernameAndPassword(String username, String password);//用户登录验证

    void add(User301 user);//添加方法

    void delete(int id);//删除方法

    User301 findById(int i);//根据序号查询

    void update(User301 user);//更新

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User301> findByPage(int start, int rows, Map<String, String[]> condition);
}
