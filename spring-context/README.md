# spring-context

spring-context 包含了aop core expression beans context

可以利用spring-context开发java 组件化应用

## 上手一个简单demo
maven依赖
```
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.2.0.RELEASE</version>
        </dependency>
    </dependencies>
```
main方法
```
public class SpringContextMain {
    public static void main(String[] args) {
        //初始化spring容器
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");
    }
}
```
关联xml配置文件
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">
    <!--<context:annotation-config />-->
    <!-- 开启扫描 默认就会打开注解 所以上面的注解驱动可以注释掉-->
    <context:component-scan base-package="top.soft1010.spring.context.service" />
    <!--<bean name="userService" class="UserServiceImpl"></bean>-->
</beans>
```
## ClassPathXmlApplicationContext 的启动
条例清晰的启动流程
```
    @Override
	public void refresh() throws BeansException, IllegalStateException {
	    //启动关闭锁
		synchronized (this.startupShutdownMonitor) {
			// 准备刷新的上下文环境 对环境变量的设置及校验
			prepareRefresh();

			 //初始化BeanFactory，并进行XML文件读取，
             //这一步之后，ClassPathXmlApplicationContext实际上就已经包含了BeanFactory所提供的功能，也就是可以进行Bean的提取等基础操作了。
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
			prepareBeanFactory(beanFactory);

			try {
				// Allows post-processing of the bean factory in context subclasses.
				postProcessBeanFactory(beanFactory);

				// Invoke factory processors registered as beans in the context.
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
				initMessageSource();

				// Initialize event multicaster for this context.
				initApplicationEventMulticaster();

				// Initialize other special beans in specific context subclasses.
				onRefresh();

				// Check for listener beans and register them.
				registerListeners();

				// Instantiate all remaining (non-lazy-init) singletons.
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
				finishRefresh();
			}
			catch (BeansException ex) {
				throw ex;
			}
			finally {
				// Reset common introspection caches in Spring's core, since we
				// might not ever need metadata for singleton beans anymore...
				resetCommonCaches();
			}
		}
	}
```
#### prepareRefresh() 准备刷新的上下文环境
源码
```
	protected void prepareRefresh() {
		this.startupDate = System.currentTimeMillis();
		this.active.set(true);

		if (logger.isInfoEnabled()) {
			logger.info("Refreshing " + this);
		}

		// 初始化属性 可在子类中实现
		initPropertySources();

		// 校验属性
		getEnvironment().validateRequiredProperties();

		this.earlyApplicationEvents = new LinkedHashSet<ApplicationEvent>();
	}
```
设置自己的properties
```
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
```
#### obtainFreshBeanFactory() 初始化beanfactory 并解析xml文件
```
protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
		refreshBeanFactory();
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();
		if (logger.isDebugEnabled()) {
			logger.debug("Bean factory for " + getDisplayName() + ": " + beanFactory);
		}
		return beanFactory;
	}
```
```
protected final void refreshBeanFactory() throws BeansException {
		if (hasBeanFactory()) {
			destroyBeans();
			closeBeanFactory();
		}
		try {
		    //初始化beanfactory实例，
			DefaultListableBeanFactory beanFactory = createBeanFactory();
			beanFactory.setSerializationId(getId());
			//定制beanfactory 包括是否重写bean定义
			customizeBeanFactory(beanFactory);
			//初始化DodumentReader，并进行XML文件读取及解析
			loadBeanDefinitions(beanFactory);
			synchronized (this.beanFactoryMonitor) {
			    //讲实例化的beanfactory对象赋给全局变量
				this.beanFactory = beanFactory;
			}
		}
		catch (IOException ex) {
			throw new ApplicationContextException("I/O error parsing bean definition source for " + getDisplayName(), ex);
		}
	}
```
````
    @Override
	protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
		// 为指定beanFactory创建XmlBeanDefinitionReader
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

		// 为XmlBeanDefinitionReader设置环境变量
		beanDefinitionReader.setEnvironment(this.getEnvironment());
		beanDefinitionReader.setResourceLoader(this);
		beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));

		// 
		initBeanDefinitionReader(beanDefinitionReader);
		//使用XmlBeanDefinitionReader的loadBeanDefinitions方法进行配置文件的加载及注册
		loadBeanDefinitions(beanDefinitionReader);
	}
````
#### finishRefresh()
```
	protected void finishRefresh() {
		// 初始化单例lifecycleProcessor 首先从beanfactory查找，找不到使用DefaultLifecycleProcessor创建一个
		initLifecycleProcessor();

		// lifecycleProcessor将实现了Lifecycle接口的bean按照phase(SmartLifecycle实现类)值由小到大依次执行start()
		getLifecycleProcessor().onRefresh();

		// Publish the final event.
		publishEvent(new ContextRefreshedEvent(this));

		// Participate in LiveBeansView MBean, if active.
		LiveBeansView.registerApplicationContext(this);
	}      
```
![image](http://soft1010.top/img/spring-lifecycleprocessor-1.jpg)


