package com.ycc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化filter方法。。。。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行filter方法。。。。。");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println(req.getRequestURI()+":请求的连接是");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("filter被摧毁了。。。。。");
    }
}
