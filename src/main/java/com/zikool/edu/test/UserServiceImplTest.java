package com.zikool.edu.test;

import com.zikool.edu.common.bean.User;
import com.zikool.edu.common.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-14
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */

public class UserServiceImplTest {
    ApplicationContext   applicationContext = new ClassPathXmlApplicationContext("bean.xml") ;

    @Test
    public void testSave (){
        User user  =new User();
        user.setName("张无忌");
        user.setPassword("666666");
        user.setIdentityCard("360423198710342345");
        user.setRoleName("学员");
        user.setGender('男');
        user.setOrganizationName("武当");
        user.setAddress("武当山");
        UserService userService  = (UserService) applicationContext.getBean("userService");
        try {
            System.out.println("userService------------------------>"+userService);
            userService.save(user)     ;
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
