package top.soft1010.spring.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.soft1010.spring.context.service.UserService;

/**
 * Created by bjzhangjifu on 2019/6/24.
 */
public class TestSpringContextMain {
    public static void main(String[] args) {
        System.setProperty("test", "applicationContext");
        System.getProperties().list(System.out);

        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring/${test}.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
        userService.queryUser("312");
    }
}
