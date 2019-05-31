package top.soft1010.spring.mvc.manual.core;

import java.lang.annotation.*;

/**
 * Created by bjzhangjifu on 2019/2/21.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {

    String value() default "";
}
