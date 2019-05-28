package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet",urlPatterns = "/test.do")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到请求头中的cookie(可能有多个)
        //CookieServlet1的测试类
        Cookie[] cookies=req.getCookies();
        for (Cookie cookie:cookies){
            System.out.print(cookie.getName());
            System.out.print("=");
            System.out.print(cookie.getValue());
            System.out.println();
        }
    }
}
