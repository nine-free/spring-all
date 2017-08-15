package com.soft1010.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jifuzhang on 17/8/15.
 */
@Controller
@RequestMapping("redirect")
public class RedirectController {

    //http://localhost:8889/redirect/outer?url=http://baidu.com
    @RequestMapping("outer")
    public String outer(@RequestParam("url")String url){
        return "redirect:"+url;
    }

    //http://localhost:8889/redirect/outer?url=redirect/test
    @RequestMapping("inner")
    public String inner(@RequestParam("url")String url){
        return "redirect:/"+url;
    }

    @ResponseBody
    @RequestMapping("test")
    public String test(){
        return "test";
    }

}
