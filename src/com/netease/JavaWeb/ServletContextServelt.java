package com.netease.JavaWeb;

import com.netease.JavaWeb.util.GeneralUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author louxiujun
 * @file ServletContextServelt.java
 * @CopyRight (C) http://www.wogeeker.cn
 * @brief
 * @email louxj424@126.com
 * @date 2017/11/9
 */
public class ServletContextServelt extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init method");
        ServletContext servletContext=this.getServletContext();
        String globalData1=servletContext.getInitParameter("globalData1");
        String globalData2=servletContext.getInitParameter("globalData2");
        System.out.println("globalData1="+globalData1+"\tglobalData2="+globalData2);

        servletContext.setAttribute("attribute1","attribute_value1");

        try {
            URL url=servletContext.getResource("/WEB-INF/classes/log4j.properties");
            InputStream in=url.openStream();
            String propertyValue= GeneralUtil.getPropery(in,"log4j.rootLogger");
            System.out.println("getResource property value:"+propertyValue);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===================================");

        InputStream in2=servletContext.getResourceAsStream("/WEB-INF/classes/log4j.properties");
        String p2=GeneralUtil.getPropery(in2,"log4j.rootLogger");
        System.out.println("getResourceAsStream property value:"+p2);

        System.out.println("===================================");


        String path=servletContext.getRealPath("/WEB-INF/classes/log4j.properties");
        System.out.println(path);
        File f=new File(path);
        try {
            InputStream in3=new FileInputStream(f);
            String p3=GeneralUtil.getPropery(in3,"log4j.rootLogger");
            System.out.println("getRealPath property value:"+p3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServeltContextServelt doGet method");
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


