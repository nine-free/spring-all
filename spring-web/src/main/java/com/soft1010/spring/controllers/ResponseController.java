package com.soft1010.spring.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jifuzhang on 17/8/15.
 */
@Controller
@RequestMapping(value = "response", method = RequestMethod.GET)
public class ResponseController {

    @ResponseBody
    @RequestMapping(value = "consumes", consumes = "application/json", produces = "application/json")
    public String consumes(@RequestParam("name") String name) {
        return name;
    }

    @ResponseBody
    @RequestMapping("status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<String>("403 forbiddern", HttpStatus.FORBIDDEN);
    }

    @ResponseBody
    @RequestMapping("headers")
    public ResponseEntity<String> headers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "tokenvalue");
        return new ResponseEntity<String>("headers ", httpHeaders, HttpStatus.OK);
    }
}
