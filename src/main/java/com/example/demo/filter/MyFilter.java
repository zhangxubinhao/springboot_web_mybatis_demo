package com.example.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by zhang_xubin on 2019/4/9.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
@Component
@WebFilter(urlPatterns = "/*" ,filterName = "myFilter")
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("before");
//        System.out.println("requ"+request.getInputStream().available());
        chain.doFilter(request,response);
//        System.out.println("after");
    }

    @Override
    public void destroy() {

    }
}
