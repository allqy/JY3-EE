package com.neuedu.controller;

import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServerServlet",urlPatterns = "/json.do")
public class JsonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        //User user = new User("张三", "123");
        //不在js中规定数据返回类型，就需要在服务端进行数据的格式化(将数据格式化成为json格式的数据)
        resp.getWriter().write("[{\"uName\":\"张三\",\"uPwd\":\"123\"}]");
    }
}
