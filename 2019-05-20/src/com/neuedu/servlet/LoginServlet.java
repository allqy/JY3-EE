package com.neuedu.servlet;

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

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao;
    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName=request.getParameter("username");
        String uPwd=request.getParameter("userpwd");
        //得到用户输入的密码进行加密与数据库中的密码进行比较
        Base64.Encoder encoder=Base64.getEncoder();
        byte[] uPwdArr=uPwd.getBytes();
        String newUpwd=encoder.encodeToString(uPwdArr);
        //System.out.println(uName);
        //System.out.println(uPwd);
        List<User> userlist=userDao.login(new User(uName,newUpwd));
        //System.out.println(userlist);
        if(userlist.size()>0){
            System.out.println("登录成功！！！");
            request.setAttribute("userlist",userlist);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            System.out.println("登录失败！！！");
            request.getRequestDispatcher("failLogin.jsp").forward(request,response);
        }
    }
}
