package com.liobio.mvc.controller;

import com.liobio.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName ParamController.java
 * @createTime 2021/08/07/12:39:00
 * @Description SpringMVC获取请求参数
 */
@Controller
public class ParamController {

    //    1、通过ServletAPI获取
//
//    将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password + ",cookie:" + session.getId());
        return "success";
    }

    //2、通过控制器方法的形参获取请求参数
    //
    // 在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，
    // 在DispatcherServlet中就会将请求参数赋值给相应的形参
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping("/testParam_plus")
    public String testParam(
            //required：设置是否必须传输此请求参数，默认值为true
            //若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置defaultValue属性，则页面报错400：
            // Required String parameter 'xxx' is not present；
            // 若设置为false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
            //defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值
            @RequestParam(value = "user_name", required = false, defaultValue = "name") String username,
            String password,
            String[] hobby,
            //@RequestHeader是将请求头信息和控制器方法的形参创建映射关系
            //@RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
            @RequestHeader(value = "header", required = true, defaultValue = "localhost:8080") String host,
            @CookieValue("JSESSIONID") String JSESSIONID) {
        //若请求参数中出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));
        System.out.println("host:" + host);
        System.out.println("JSESSIONID:" + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }

}
