package com.netease.JavaWeb.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServelt extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
//        System.out.println("service");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        System.out.println("doPost");
        process(req,resp);
    }


    protected void process(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        RequestDispatcher dispatcher=null;
        String userName=req.getParameter("userName");
        String userPassword=req.getParameter("userPassword");

        HttpSession session=req.getSession();//创建一个session对象
        session.setMaxInactiveInterval(2*60);//设置session的最长失效时间
        session.invalidate();//使得当前session失效

        String name=(String)session.getAttribute("userName");
        if (name==null){//首次登录无法获取到name,则name必为空
            session.setAttribute("userName",userName);
            session.setAttribute("userPassword",userPassword);
        }else
        {
            System.out.printf("%s second login\n",name);
        }


        //服务器端创建Cookie对象
        Cookie userNameCookie=new Cookie("userName",userName);
        Cookie userPasswordCookie=new Cookie("userPassword",userPassword);

        //设置Cookie的最大存留时间
        userNameCookie.setMaxAge(2*60);
        userPasswordCookie.setMaxAge(2*60);

        //将Cookie对象返还给浏览器
        resp.addCookie(userNameCookie);
        resp.addCookie(userPasswordCookie);

        //优先从Cookie中获取参数，可以实现表单自动登录的功能
        Cookie [] cookies=req.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("userName")){
                    userName=cookie.getValue();
                }
                if (cookie.getName().equals("userPassword")){
                    userPassword=cookie.getValue();
                }
            }
        }

        System.out.println("userName:"+userName);
        System.out.println("userPassword:"+userPassword);

        if (userName.equals("123")&&userPassword.equals("123")){
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer=resp.getWriter();
            writer.println("<html>");
            writer.println("<head><title>用户中心</title></head>");
            writer.println("<body>");
            writer.println("<p>用户名："+userName+"</p>");
            writer.println("<p>密码："+userPassword+"</p>");
            writer.println("</body>");
            writer.println("</html>");
            writer.close();
        }else{
            dispatcher=req.getRequestDispatcher("/error.html");

        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }


}
