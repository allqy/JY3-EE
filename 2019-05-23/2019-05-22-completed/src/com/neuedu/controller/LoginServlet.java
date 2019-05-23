package com.neuedu.controller;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //System.out.println("**************************");
        String uname=request.getParameter("uname");
        //System.out.println(uname);
        String upwd=request.getParameter("upwd");
        Base64.Encoder encoder=Base64.getEncoder();
        byte[] upwdArr=upwd.getBytes();
        String newPwd=encoder.encodeToString(upwdArr);
        //System.out.println("++++++++++++++"+newPwd);
        List<User> userlist=userDao.login(uname,newPwd);
        //System.out.println(userlist);
        if (null!=userlist&&userlist.size()>0){
            request.setAttribute("userlist",userlist);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
