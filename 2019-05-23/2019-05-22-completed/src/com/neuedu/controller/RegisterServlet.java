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

@WebServlet(name = "RegisterServlet",urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd");
        Base64.Encoder encoder=Base64.getEncoder();
        byte[] upwdArr=upwd.getBytes();
        String newPwd=encoder.encodeToString(upwdArr);
        User user=new User(uname,newPwd);
        boolean result=userDao.addOneUser(user);
        if(result==true){
            List<User> userlist=userDao.queryAllUser();
            request.setAttribute("userlist",userlist);
            request.getRequestDispatcher("userlist.jsp").forward(request,response);
        }else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
