package com.babusa.learn.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println(req.getAttributeNames());
        System.out.println("req.getServerName(): " + req.getServerName());
        System.out.println("req.getServerPort(): " + req.getServerPort());
        System.out.println("req.isSecure(): " + req.isSecure());
        System.out.println("req.getRequestURI(): " + req.getRequestURI());
        System.out.println("req.getMethod(): " + req.getMethod());
        System.out.println("req.getContextPath(): " + req.getContextPath());
        System.out.println("req.getServletPath(): " + req.getServletPath());
        System.out.println("req.getPathInfo(): " + req.getPathInfo());
        System.out.println("req.getQueryString(): " + req.getQueryString());
        res.getWriter().append("Hello World (app-03)");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doGet(req, res);
    }
}
