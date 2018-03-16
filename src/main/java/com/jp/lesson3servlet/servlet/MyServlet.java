package com.jp.lesson3servlet.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(
        name = "my",
        urlPatterns = "/myServlet",
        initParams = {
                @WebInitParam(name = "myValue", value = "servlet1")
        }
)
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = -234680663870751828L;
    private String name;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getInitParameter( "myValue" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        ServletContext servletContext = getServletContext();
        servletContext.log( "doGet ..." );
        writer.write( "this is my servlet :"+name );
    }
}
