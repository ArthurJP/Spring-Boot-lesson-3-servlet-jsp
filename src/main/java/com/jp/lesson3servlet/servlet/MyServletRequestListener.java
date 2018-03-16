package com.jp.lesson3servlet.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


//通过javax的注解实现了一次监听
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest httpServletRequest=(HttpServletRequest)sre.getServletRequest();
        ServletContext servletContext = sre.getServletContext();
        servletContext.log( "request was initialized" );
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest httpServletRequest=(HttpServletRequest)sre.getServletRequest();
        ServletContext servletContext = sre.getServletContext();
        servletContext.log( "request was destroyed" );
    }
}
