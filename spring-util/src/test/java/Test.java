import top.soft1010.spring.util.PropertyPlaceholderHelper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by bjzhangjifu on 2019/6/25.
 */
public class Test {

    @org.junit.Test
    public void test1(){
        //原始串
        String b = "{{name}{age}}";
        //实例化
        PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("{", "}");
        final Properties properties = new Properties();
        properties.put("name", "zhang");
        properties.put("age", "18");
        properties.put("zhang18", "nice");
        //获取替换之后的结果
        String result = propertyPlaceholderHelper.replacePlaceholders(b, new PropertyPlaceholderHelper.PlaceholderResolver() {
            public String resolvePlaceholder(String placeholderName) {
                return properties.getProperty(placeholderName);
            }
        });
        System.out.println(b + " --> " + result);
    }

    @org.junit.Test
    public void test() throws IOException {
        String a = "{name}{age}";
        String b = "{{name}{age}}";

        final Map<String, String> map = new HashMap<String, String>();
        map.put("name", "zhang");
        map.put("age", "18");
        map.put("zhang18", "nice");

        PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("{", "}");
        String result = propertyPlaceholderHelper.replacePlaceholders(a, new PropertyPlaceholderHelper.PlaceholderResolver() {
            public String resolvePlaceholder(String placeholderName) {
                return map.get(placeholderName);
            }
        });
        System.out.println(a + " --> " + result);
        System.out.println("----------------------------------------");

        final Properties properties = new Properties();
        properties.put("name", "zhang");
        properties.put("age", "18");
        properties.put("zhang18", "nice");

        String result2 = propertyPlaceholderHelper.replacePlaceholders(b, new PropertyPlaceholderHelper.PlaceholderResolver() {
            public String resolvePlaceholder(String placeholderName) {
                return properties.getProperty(placeholderName);
            }
        });
        System.out.println(b + " --> " + result2);

        System.out.println("-----------------------------------------");
        InputStream in = new BufferedInputStream(new FileInputStream(new File("D:\\git_project\\spring-all\\spring-util\\src\\test\\java\\test.properties")));
        properties.load(in);
        String result3 = propertyPlaceholderHelper.replacePlaceholders(b, new PropertyPlaceholderHelper.PlaceholderResolver() {
            public String resolvePlaceholder(String placeholderName) {
                return properties.getProperty(placeholderName);
            }
        });
        System.out.println(b + " --> " + result3);

    }
}
