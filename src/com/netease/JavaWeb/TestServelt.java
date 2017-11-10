package com.netease.JavaWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
* @file TestServelt.java
* @CopyRight (C) http://www.wogeeker.cn
* @brief
* @author louxiujun
* @email louxj424@126.com
* @date 2017/11/9
*/

public class TestServelt extends HttpServlet {
    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("init method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("doGet method");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("hello world");
        printWriter.close();
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("destroy method");
    }
}
