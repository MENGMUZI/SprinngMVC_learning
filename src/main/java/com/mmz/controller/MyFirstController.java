package com.mmz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : mengmuzi
 * create at:  2019-07-12  22:31
 * @description:
 * 1.告诉SpringMVC这个是一个处理器，可以处理请求
 * @Controller：标识哪个组件是控制器
 */

/**
 * HelloWorld细节
 * 1.运行流程
 *    1）客户端点击链接发送http://localhost:8080/say/hello
 *    2）来到Tomcat服务器
 *    3）SpringMVC的前端控制器收到所有请求
 *    4）来看请求地址@RequestMapping标注的哪个匹配，来找到使用哪个方法
 *    5）前端控制器找到类和方法，直接利用反射执行目标方法
 *    6）方法执行完成以后有一个返回值，SpringMVC认为这个返回值就是要去的页面地址
 *    7）用视图解析器拿到完整的地址
 *    8）前端控制器帮我们转发到页面
 *
 * 2.@RequestMapping
 *   告诉SpringMVC：这个方法用来处理什么请求
 *   这个/可以省略，也是默认从当前项目下开始，一般加上
 *
 * 3.如果web.xml中前端控制器不指定xml文件的位置？
 *   如果不指定会默认去找/WEB-INF/dispatcher-servlet.xml
 *   【xxx-servlet.xml】中的【xxx】是由【<servlet-name>dispatcher</servlet-name>】决定的。
 *
 * 4.详细研究@RequestMapping的属性
 *   * method: 限定请求方式
 *      method = RequestMethod.[GET][POST][DELETE]
 *      不是规定方式会报错：4xx(都是客户端错误)
 *      HTTP Status 405 – Method Not Allowed
 *
 *   * params: 规定请求的参数
 *      params和headers支持简单的表达式：
 *         param1:表示请求必须包含名为param1的请求参数
 *                eg: params = {"username"} (404)
 *         !param1:表示请求必须不包含名为param1的请求参数
 *                eg: params = {"!username"}
 *         param1 != value1: 表示请求包含名为param1的请求参数，但是其值不能为 value1
 *                eg: params = {"username !=123"}
 *         {"param1 = value1","param2"}:请求必须包含名为param1和param2的
 *                eg: params = {"username !=123","pwd","!age"}
 *
 *   * headers: 规定请求头
 *
 * 5. @RequestMapping的模糊匹配（Ant风格): URL地址可以写成模糊的通配符:? * **
 *    ? :能替代任意字符
 *       @RequestMapping("/test0?") 模糊和精确之间，精确优先
 *    * :能替代任意多个字符，和一层路径
 *       @RequestMapping("/test0*") 或者
 *       @RequestMapping("/a/ * /test01")
 *
 *    ** :能替代多层路径
 *       @RequestMapping("/a/ ** /test01")
 *
 * 6.REST 简洁的URL提交请求，以请求的方式区分对资源的操作（Put Get Post）
 *        从页面上只能发起两种请求，GET和POST
 *
 *
 * 7.SpringMVC如何获取请求带来的各种信息
 * @RequestParam: 获取请求参数(是?后面的值)
 *          @RequestParam("user") String  username
 *          username = request.getParameter()
 *               value: 指定获取参数的key
 *               required(): 这个参数是否必须
 *               defailtValue():默认值，没有带默认是null
 *
 * @RequestHeader:获取请求头中某个key的值
 *          @RequestHeader("User-Agent") String userAgent
 *          request.getHeader("User-Agent")
 *
 * @CookieValue: 获取某个cookie的值
 *          @CookieValue("JSESSIONID") String jid
 *
 *
 *
 *
 *
 *
 *
 */


@Controller
//@RequestMapping(value = "/say",method = RequestMethod.GET,params = {"username !=123","pwd","!age"})
@RequestMapping("/say")
public class MyFirstController {
    //  /代表当前项目下开始，处理当前项目下的hello请求
    @RequestMapping("/hello")
    public String myFirstRequest(){
        System.out.println("请求收到了。。。。。。正在处理中");
        return "success";
    }
    //路径上的占位符{变量名}
    @RequestMapping("/user/{id}")
    public String pathVariableTest(@PathVariable("id") String id){
        return "success";
    }

    @RequestMapping("/test01")
    public String test01(@RequestParam(value = "name", required = false, defaultValue = "hehe") String  username){
        System.out.println("这个参数值：" + username);
        return "success";
    }

    @RequestMapping("/test02")
    public String test02(@RequestHeader("User-Agent") String userAgent, @CookieValue("JSESSIONID") String jid){
        System.out.println("获取请求头中的信息：" + userAgent);
        System.out.println("获取cookie中的JSESSIONID的值：" + jid);
        return "success";
    }
}


