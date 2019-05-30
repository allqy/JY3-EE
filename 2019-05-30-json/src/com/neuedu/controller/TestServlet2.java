package com.neuedu.controller;

import com.neuedu.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "TestServlet2",urlPatterns = "/test2.do")
public class TestServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("******************************");
        Comment comment1 = new Comment("张三", "这蛋炒饭也太好吃了吧!!!");
        Comment comment2 = new Comment("王五", "地板非常好!!!");
        List<Comment> commentList=new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);
        String name = req.getParameter("name");
        //System.out.println(name);
        Comment finalComm=null;
        for (Comment comment:commentList){
            if (name.equals(comment.getUname())){
                finalComm=comment;
                break;
            }else {
                finalComm=new Comment(name,null);
            }
        }
        String uName=finalComm.getUname();
        //System.out.println(uName);
        String uComm=finalComm.getComments();
        //System.out.println(uComm);
        resp.getWriter().write("{\"uName\":"+uName+",\"uComm\":"+uComm+"}");
    }
}
