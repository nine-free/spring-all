package top.soft1010.spring.context;

import top.soft1010.spring.context.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jifuzhang on 17/8/11.
 */
public class SpringContextMain {

    public static void main(String[] args) {

        //spring容器
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ClassPathXmlApplicationContext classPathXmlApplicationContext2 =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        String[] aliases = classPathXmlApplicationContext.getAliases("userService");
        String applicationName = classPathXmlApplicationContext.getApplicationName();
        UserService userService1 = classPathXmlApplicationContext.getBean(UserService.class);
        Class cls = classPathXmlApplicationContext.getType("userService");
        System.out.println(cls.getPackage() + cls.getName());
        UserService userService2 = (UserService) classPathXmlApplicationContext.getBean("userService");
        System.out.println(userService2.queryUser("123"));
    }
}
