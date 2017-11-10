package com.netease.JavaWeb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletRedictExample extends HttpServlet{
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");

        PrintWriter writer=resp.getWriter();
        resp.setContentType("text/html;charset=GBK");
        writer.println("<html>");
        writer.println("<head><title>forward example</title></head>");
        writer.println("<body>");
        writer.println("<p>user:"+user+"</p>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }


}
