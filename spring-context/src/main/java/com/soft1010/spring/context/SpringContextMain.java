package com.soft1010.spring.context;

import com.soft1010.spring.context.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jifuzhang on 17/8/11.
 */
public class SpringContextMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
        System.out.println(userService.queryUser("123"));
    }
}
