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
import java.util.List;

@WebServlet(name = "DelUserServlet",urlPatterns = "/delUser.do")
public class DelUserServlet extends HttpServlet {
    UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName=request.getParameter("uname");
        //System.out.println("************************"+uName);
        boolean res=userDao.delUserByName(uName);
        if (res==true){
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
