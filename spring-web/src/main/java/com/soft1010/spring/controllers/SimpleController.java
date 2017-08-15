package com.soft1010.spring.controllers;

import com.soft1010.spring.model.User;
import com.soft1010.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by jifuzhang on 17/8/11.
 */
@Controller
@RequestMapping("/simple")
public class SimpleController {

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

    @ResponseBody
    @RequestMapping(value = "user/{id}/{age}", method = RequestMethod.GET)
    public String getUser(@PathVariable(value = "id") Long id, @PathVariable(value = "age") Integer age) {
        User user = userService.getUserById(id);
        user.setAge(age);
        return "hi " + user == null ? null : user.toString();
    }

}
