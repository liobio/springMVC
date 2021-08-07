package com.liobio.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName RequestMappingController.java
 * @createTime 2021/08/06/22:39:00
 * @Description
 */
@Controller
//@RequestMapping(/hello) @**RequestMapping标识一个类**：设置映射请求的请求路径的初始信息
public class RequestMappingController {

    @RequestMapping("/hello")//@**RequestMapping标识一个方法**：设置映射请求请求路径的具体信息
    public String helloliobio() {
        return "success";
    }

    /**
     * @title RequestMappingController.java
     * @author LIOBIO
     * @updateTime 2021/8/6 23:03
     * @description
     * @RequestMapping注解的value属性必须设置，至少通过请求地址匹配请求映射
     * @RequestMapping注解的method属性通过请求的请求方式（get或post）匹配请求映射 RequestMapping注解的method属性是一个RequestMethod类型的数组，表示该请求映射能够匹配多种请求方式的请求
     * <p>
     * 若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错405：Request method 'POST' not supported
     */
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    /**
     * @title RequestMappingController.java
     * @author LIOBIO
     * @updateTime 2021/8/6 23:05
     * @description 对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解
     * <p>
     * 处理get请求的映射-->@GetMapping
     * <p>
     * 处理post请求的映射-->@PostMapping
     * <p>
     * 处理put请求的映射-->@PutMapping
     * <p>
     * 处理delete请求的映射-->@DeleteMapping
     */

    @GetMapping("/testGetMapping")//处理get请求的映射-->@GetMapping
    public String testGetMapping() {
        return "success";
    }

    /**
     * @title RequestMappingController.java
     * @author LIOBIO
     * @updateTime 2021/8/6 23:20
     * @description 2、常用的请求方式有get，post，put，delete
     * <p>
     * 但是目前浏览器只支持get和post，若在form表单提交时，为method设置了其他请求方式的字符串（put或delete），则按照默认的请求方式get处理
     */
    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }


    //@RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
    //
    //@RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信息和请求映射的匹配关系
    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password!=123456"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }


    //  SpringMVC支持ant风格的路径
    //
    //  ？：表示任意的单个字符
    //
    //  *：表示任意的0个或多个字符
    //
    //  \**：表示任意的一层或多层目录
    //
    //  注意：在使用\**时，只能使用/**/xxx的方式
    //@RequestMapping("/a?a/testAnt")
    //@RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
    //最终输出的内容为-->id:1,username:admin
}
