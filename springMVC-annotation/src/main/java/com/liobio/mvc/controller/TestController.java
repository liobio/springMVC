package com.liobio.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName TestController.java
 * @createTime 2021/08/15/16:10:00
 * @Description
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
