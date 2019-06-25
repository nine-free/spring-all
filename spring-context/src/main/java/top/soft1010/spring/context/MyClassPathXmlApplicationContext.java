package top.soft1010.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bjzhangjifu on 2019/6/6.
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    @Override
    protected void initPropertySources() {
        super.initPropertySources();
        //可以在spring容器中获取到该属性
        getEnvironment().setActiveProfiles("online");
        //设置必须属性，如果不存在，启动抛出异常
        getEnvironment().setRequiredProperties("app.name");
    }
}
