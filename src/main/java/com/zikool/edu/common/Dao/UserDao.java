package com.zikool.edu.common.Dao;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-10
 * Time: 下午6:46
 * To change this template use File | Settings | File Templates.
 */
import com.zikool.edu.common.bean.User;
public interface  UserDao{
            User findUserById(int id);
            User findUser(String identityCard,String password);
     }
