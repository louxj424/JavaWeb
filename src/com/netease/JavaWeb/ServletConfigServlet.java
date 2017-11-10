package com.netease.JavaWeb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author louxiujun
 * @file ServletConfigServlet.java
 * @CopyRight (C) http://www.wogeeker.cn
 * @brief
 * @email louxj424@126.com
 * @date 2017/11/9
 */

public class ServletConfigServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init method");
        ServletConfig servletConfig = this.getServletConfig();
        String v1 = servletConfig.getInitParameter("data1");
        String v2 = servletConfig.getInitParameter("data2");
        System.out.println("v1=" + v1 + "\tv2=" + v2);

        ServletContext servletContext = this.getServletContext();
        String globalData1 = servletContext.getInitParameter("globalData1");
        String globalData2 = servletContext.getInitParameter("globalData2");
        System.out.println("globalData1=" + globalData1 + "\tglobalData2=" + globalData2);

        String attribute_value1=(String)servletContext.getAttribute("attribute1");
        System.out.println("attribute1=" + attribute_value1 );
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletConfigServlet doGet method");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method");

    }

    @Override
    public void destroy() {
        System.out.println("destroy method");
    }
}
