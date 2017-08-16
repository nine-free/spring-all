package com.soft1010.spring.test;

import com.soft1010.spring.context.model.User;
import com.soft1010.spring.context.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jifuzhang on 17/8/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class SpringContextTest {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryUser(){
        List<User> users = userService.queryUser("zhang");
        System.out.println();
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setName("zhang");
        userService.saveUser(user);
    }
}
