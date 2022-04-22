package com.ycc.config;

import com.ycc.redis.CacheUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * @author ycc
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    private CacheUtils cacheUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功了");

        //跳转成功的页面
        Object details = authentication.getDetails();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            System.out.println("获取到的用户为1：" + ((UserDetails) principal).getUsername());
            List<GrantedAuthority> authorities = (List<GrantedAuthority>) ((UserDetails) principal).getAuthorities();
            System.out.println(authorities);
            cacheUtils.set("getUser", new User(((UserDetails) principal).getUsername(), ((UserDetails) principal).getPassword(), authorities), 3600L);
        } else if (principal instanceof Principal) {
            System.out.println("获取到的用户为2：" + ((Principal) principal).getName());
        }
        System.out.println(details + "返回的对象");
        //计数登录次数
        cacheUtils.incr("loginTimes",1);
        httpServletResponse.sendRedirect("/home");
//        httpServletRequest.getRequestDispatcher("/home").forward(httpServletRequest,httpServletResponse);
    }
}
