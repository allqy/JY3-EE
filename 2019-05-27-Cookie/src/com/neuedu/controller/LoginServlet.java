package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    //使用Cookie实现用户的免登录功能
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        if(null!=uname && null!=upwd){
            Cookie cookie1 = new Cookie("uname", uname);
            Cookie cookie2 = new Cookie("upwd", upwd);
            cookie1.setPath("/");
            cookie2.setPath("/");
            cookie1.setMaxAge(7*24*60*60);
            cookie2.setMaxAge(7*24*60*60);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            resp.sendRedirect("login.do");
        }else {
            Cookie[] cookies = req.getCookies();
            for (Cookie cookie:cookies){
                if("uname".equals(cookie.getName())){
                    uname=cookie.getValue();
                }
                if("upwd".equals(cookie.getName())){
                    upwd=cookie.getValue();
                }
            }
            if(null!=uname && null!=upwd){
                req.setAttribute("uname",uname);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else{
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        }
    }
}
