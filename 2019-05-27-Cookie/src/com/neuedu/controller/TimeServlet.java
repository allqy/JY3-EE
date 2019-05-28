package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TimeServlet",urlPatterns = "/time.do")
public class TimeServlet extends HttpServlet {
    //用Cookie实现自动获取用户上次登录时间功能
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式，防止中文乱码
        resp.setContentType("text/html;charset=utf-8");
        //获取系统当前时间
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String finalTime = simpleDateFormat.format(date);
        //设置Cookie
        Cookie cookie = new Cookie("time", finalTime);
        cookie.setPath("/");
        cookie.setMaxAge(7*24*60*60);
        resp.addCookie(cookie);
        Cookie[] cookies = req.getCookies();
        String time=null;
        for(Cookie cookie1:cookies){
            if("time".equals(cookie1.getName())){
                time=cookie1.getValue();
            }
        }
        if(null!=time){
            resp.getWriter().write("您上次登录的时间为:"+time);
        }else{
            resp.getWriter().write("欢迎您首次登录！！！");
        }
    }
}
