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

@WebServlet(name = "UpdateUserServlet",urlPatterns = "/updateUser.do")
public class UpdateUserServlet extends HttpServlet {
    UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("***********************************");
        String uname=request.getParameter("midUname");
        System.out.println(uname);
        String upwd=request.getParameter("upwd");
        System.out.println(upwd);
        Base64.Encoder encoder=Base64.getEncoder();
        byte[] uPwdArr=upwd.getBytes();
        String newUpwd=encoder.encodeToString(uPwdArr);
        boolean result=userDao.updateUserByName(uname,newUpwd);
        System.out.println(result);
        if(result==true){
            List<User> userlist=userDao.queryAllUser();
            request.setAttribute("userlist",userlist);
            request.getRequestDispatcher("userlist.jsp").forward(request,response);
        }
//        else {
//            response.sendRedirect("error.jsp");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
