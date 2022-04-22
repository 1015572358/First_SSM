package com.ycc.test.controller;

import com.ycc.annotion.MyAnnotion;
import com.ycc.config.User;
import com.ycc.redis.CacheUtils;
import com.ycc.test.service.HellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloWorld {
    @Autowired
    private HellowService hellowService;
    @Autowired
    private CacheUtils cacheUtils;

    @RequestMapping("/home")
    @MyAnnotion("我这是个测试的注解接口")
    public String index(HttpServletRequest request) throws Exception {
        User getUser = cacheUtils.get("getUser", User.class);
        int loginTimes = cacheUtils.getInt("loginTimes");
//        System.out.println(hellowService.testAop());
        System.out.println("我是被执行的方法");
        request.setAttribute("user",getUser);
        request.setAttribute("loginTimes",loginTimes);
        return "home";
    }
}
