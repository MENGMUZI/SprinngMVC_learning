package com.mmz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : mengmuzi
 * create at:  2019-07-12  22:31
 * @description:
 * 1.告诉SpringMVC这个是一个处理器，可以处理请求
 * @Controller,标识那个组件是控制器
 */

@Controller
@RequestMapping("/say")
public class MyFirstController {
    //  /代表当前项目下开始，处理当前项目下的hello请求
    @RequestMapping("/hello")
    public String myFirstRequest(){
        System.out.println("请求收到了。。。。。。正在处理中");
        return "success";
    }

}
