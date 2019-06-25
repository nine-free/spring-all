package top.soft1010.spring.context;

/**
 * Created by bjzhangjifu on 2019/6/6.
 */
public class MySpringContextMain {

    public static void main(String[] args) {
        System.setProperty("app.name", "123");
        MyClassPathXmlApplicationContext myClassPathXmlApplicationContext =
                new MyClassPathXmlApplicationContext("spring/applicationContext.xml");
        myClassPathXmlApplicationContext.getBean("userService");
        String[] profiles = myClassPathXmlApplicationContext.getEnvironment().getActiveProfiles();
        System.out.println("=====");
        myClassPathXmlApplicationContext.stop();
    }
}
