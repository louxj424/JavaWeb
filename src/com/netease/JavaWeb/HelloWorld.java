package com.netease.JavaWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
* @file HelloWorld.java
* @CopyRight (C) http://www.wogeeker.cn
* @brief
* @author louxiujun
* @email 279797073@qq.com
* @date 2017/11/9
*/

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");

        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}