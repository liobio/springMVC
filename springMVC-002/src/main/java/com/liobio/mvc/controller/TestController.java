package com.liobio.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName TestController.java
 * @createTime 2021/08/08/15:34:00
 * @Description
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index" ;
    }

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }

    @RequestMapping("/test_rest")
    public String testRest(){
        return "test_rest";
    }
}
