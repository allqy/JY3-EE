package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet1",urlPatterns = "/cook.do")
public class CookieServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //新建一个Cookie(cookie对象是以key-value键值对的形式存放的,并且value的值不能为汉字)
        Cookie cookie=new Cookie("uname","zhangsan");
        //在响应的响应头中添加cookie并且返回给浏览器,同一个浏览器再次发送请求时会自动携带该cookie发送请求
        //可以在页面的检查Network下的响应头中来查看cookie
        resp.addCookie(cookie);
    }
}
