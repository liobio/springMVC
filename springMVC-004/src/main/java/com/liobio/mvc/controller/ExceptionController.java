package com.liobio.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName ExceptionController.java
 * @createTime 2021/08/13/13:43:00
 * @Description
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }

}

