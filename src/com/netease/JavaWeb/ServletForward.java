package com.netease.JavaWeb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletForward extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建转发对象
        RequestDispatcher dispatcher=req.getRequestDispatcher("/ServletForwardExample");
        dispatcher.forward(req,resp);

        RequestDispatcher dispatcher1=this.getServletContext().getNamedDispatcher("ServletForwardExample");
        RequestDispatcher dispatcher2=this.getServletContext().getRequestDispatcher("/ServletForwardExample");

    }


}
