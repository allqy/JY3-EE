package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet2",urlPatterns = "/coo/cook.do")
public class CookieServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("uname","tom");
        //为cookie设置访问的路径，只有/coo下的Servlet才能访问该cookie
        cookie.setPath("/coo/");
        //为cookie设置最大的记忆时间(以秒为单位)(即使浏览器关闭之后重新打开，只要不超过规定的时间，发送请求时
        // 请求头中还是会携带cookie的)
        cookie.setMaxAge(60);
        resp.addCookie(cookie);
    }
}
