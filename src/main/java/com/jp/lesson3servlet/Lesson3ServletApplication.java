package com.jp.lesson3servlet;

import com.jp.lesson3servlet.servlet.MyServletRequestListener;
import com.jp.lesson3servlet.springboot.servlet.MyFilter2;
import com.jp.lesson3servlet.springboot.servlet.MyServlet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.EventListener;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.jp.lesson3servlet.servlet")
public class Lesson3ServletApplication extends SpringBootServletInitializer {
    //这里继承SpringBootServletInitializer,引入jsp
    public static void main(String[] args) {
        SpringApplication.run( Lesson3ServletApplication.class, args );
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet( new MyServlet2() );
        servletServletRegistrationBean.setName( "my-servlet2" );
        servletServletRegistrationBean.addUrlMappings( "/spring-boot/myServlet2" );
        servletServletRegistrationBean.addInitParameter( "myValue", "servlet2 " );
        return servletServletRegistrationBean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter( new MyFilter2() );
        filterFilterRegistrationBean.addServletNames( "my-servlet2" );
        filterFilterRegistrationBean.setDispatcherTypes( DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE );
        return filterFilterRegistrationBean;
    }

    //    这里spring创建了第二次监听
    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<EventListener> eventListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        eventListenerServletListenerRegistrationBean.setListener( new MyServletRequestListener() );
        return eventListenerServletListenerRegistrationBean;
    }

    //    组装jsp
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources( Lesson3ServletApplication.class );
        return builder;
    }

}
