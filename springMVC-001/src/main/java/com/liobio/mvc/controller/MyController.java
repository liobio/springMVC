package com.liobio.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName Mycontroller.java
 * @createTime 2021/08/05/21:01:00
 * @Description
 */
@Controller
public class MyController {

    @RequestMapping("/")
    public String index() {
        //设置视图名称
        return "index";
    }
    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }


}
