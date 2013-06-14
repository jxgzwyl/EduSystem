package com.zikool.edu.common.service;

import com.zikool.edu.common.bean.User;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-10
 * Time: 下午10:46
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    User getUserByLoginNameAndPassword(String loginName, String password);
    User getUserById(int Id);
    User getUserByIdentityCard(String identityCard);
    User getUserByIdentityCardAndPassword(String identityCard,String password);
    int  save(User user) throws IllegalAccessException;
    int  update(User user) throws IllegalAccessException;
    int delete(int Id);


}
