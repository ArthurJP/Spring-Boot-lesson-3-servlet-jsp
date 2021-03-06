package com.jp.lesson3servlet.springboot.servlet;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        ServletContext servletContext = request.getServletContext();
//        servletContext.log( "/myServlet2 was filtered." );
        dosomething();
        filterChain.doFilter( request,response );
    }

    public void dosomething(){
//        RequestContextHolder保存了request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();

        ServletContext servletContext = request.getServletContext();

        String requestURI = request.getRequestURI();

        servletContext.log( "/myServlet2 was filtered. URI:"+requestURI );
    }
}
