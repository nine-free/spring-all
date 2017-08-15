package com.soft1010.spring.controllers;

import com.soft1010.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by jifuzhang on 17/8/14.
 */
@Controller
@RequestMapping("views/")
public class ViewsController {

    @RequestMapping("html")
    public String html(Model model) {
        model.addAttribute("name", "zhang");
        model.addAttribute("age", 12);
        return "views/html";
    }

    @RequestMapping("html3")
    public void html2(Model model) {
        model.addAttribute("name", "zhang");
        model.addAttribute("age", 12);
    }

    @RequestMapping(value = "{name}/{age}", method = RequestMethod.GET)
    public String html3(@PathVariable String name, @PathVariable Integer age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "views/html";
    }

    @RequestMapping("bean/{name}/{age}")
    public String html4(@PathVariable String name, @PathVariable Integer age, Model model) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        model.addAttribute(user);
        return "views/html2";
    }

    @RequestMapping("html5")
    public String html5(@RequestParam("name") String name, @RequestParam(value = "age", defaultValue = "12") Integer age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "views/html";
    }

}
