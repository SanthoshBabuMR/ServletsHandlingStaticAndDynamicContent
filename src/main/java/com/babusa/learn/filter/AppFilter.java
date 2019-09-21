package com.babusa.learn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class AppFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("App Filter:: init");
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("App Filter:: doFilter");
        HttpServletRequest httpServletReq = (HttpServletRequest) request;
        String path = httpServletReq.getRequestURI().substring(httpServletReq.getContextPath().length());
        System.out.println("path: " + path);

        String staticResourcePath = config.getInitParameter("staticResourcePath");
        String dynamicResourcePath = config.getInitParameter("dynamicResourcePath");

        if (path.startsWith("/" + staticResourcePath)) {
            // Goes to default servlet.
            System.out.println("static content");
            // httpServletReq.getServletContext().getNamedDispatcher("default").forward(request, response);
            chain.doFilter(request, response);
        } else {
            System.out.println("dynamic content");
            request.getRequestDispatcher("/" + dynamicResourcePath + path ).forward(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("App Filter:: destroy");
    }
}
