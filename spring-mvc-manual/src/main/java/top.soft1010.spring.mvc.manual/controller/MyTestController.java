package top.soft1010.spring.mvc.manual.controller;


import top.soft1010.spring.mvc.manual.core.MyController;
import top.soft1010.spring.mvc.manual.core.MyRequestMapping;
import top.soft1010.spring.mvc.manual.core.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bjzhangjifu on 2019/2/21.
 */
@MyController
@MyRequestMapping(value = "/mvc")
public class MyTestController {

    @MyRequestMapping(value = "/test")
    public Object test(@MyRequestParam(value = "name") String name, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
