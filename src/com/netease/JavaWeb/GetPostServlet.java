package com.netease.JavaWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
* @file GetPostServlet.java
* @CopyRight (C) http://www.wogeeker.cn
* @brief
* @author louxiujun
* @email louxj424@126.com
* @date 2017/11/9
*/

public class GetPostServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet method");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        String name1=req.getParameter("name1");
        String pw1=req.getParameter("pw1");
        out.println("<html>");
        out.println("   <head><title></title></head>");
        out.println("<body>");
        out.println("调用get方法");
        out.println("<br></br>");
        out.println("用户名："+name1);
        out.println("<br></br>");
        out.println("密码："+pw1);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        String name2=req.getParameter("name2");
        String pw2=req.getParameter("pw2");
        out.println("<html>");
        out.println("   <head><title></title></head>");
        out.println("<body>");
        out.println("调用post方法");
        out.println("<br></br>");
        out.println("用户名："+name2);
        out.println("<br></br>");
        out.println("密码："+pw2);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("destroy method");
    }
}
