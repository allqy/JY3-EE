package com.neuedu.controller;

import com.neuedu.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JsonServlet2",urlPatterns = "/json2.do")
public class JsonServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        User user1= new User("张三", "123");
        User user2= new User("李四", "456");
        User user3= new User("王五", "789");
        List<User> userlist=new ArrayList<>();
        userlist.add(user1);
        userlist.add(user2);
        userlist.add(user3);
        JSONArray jsonArray = JSONArray.fromObject(userlist);
        resp.getWriter().write(jsonArray.toString());
    }
}
