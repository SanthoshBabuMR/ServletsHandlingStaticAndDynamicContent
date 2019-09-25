package com.babusa.learn.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        StringBuffer data = new StringBuffer();

        data.append("\n URL endpoint: "+ req.getPathInfo());
        data.append("\n req.getAttributeNames(): "+ req.getAttributeNames());
        data.append("\n req.getServerName(): " + req.getServerName());
        data.append("\n req.getServerPort(): " + req.getServerPort());
        data.append("\n req.isSecure(): " + req.isSecure());
        data.append("\n req.getRequestURI(): " + req.getRequestURI());
        data.append("\n req.getMethod(): " + req.getMethod());
        data.append("\n req.getContextPath(): " + req.getContextPath());
        data.append("\n req.getServletPath(): " + req.getServletPath());
        data.append("\n req.getPathInfo(): " + req.getPathInfo());
        data.append("\n req.getQueryString(): " + req.getQueryString());
        String out = data.toString();
        System.out.println(out);
        out = "<h1>Hello World (app-03)</h1><br />" + out;
        out = out.replaceAll("req.", "<br />req.");
        res.getWriter().append(out);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        doGet(req, res);
    }
}
