package com.soft1010.spring.controllers;

import com.soft1010.spring.model.User;
import com.soft1010.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jifuzhang on 17/8/11.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/hi")
    public String hi(@RequestParam(name = "name") String name) {
        User user = userService.getUserByName(name);
        return "hi " + user == null ? null : user.toString();
    }

}
