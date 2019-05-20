package com.neuedu.servlet;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.entity.User;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "UserServlet",urlPatterns = "/User")
public class UserServlet extends HttpServlet {
    UserDao userDao;
    @Override
    public void init() throws ServletException {
        userDao=new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd");
        //使用base64对密码进行加密
        byte[] uPwdArr=upwd.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        String newUpwd=encoder.encodeToString(uPwdArr);
        boolean result=userDao.addOneUser(new User(uname,newUpwd));
        if(result==true){
            System.out.println("添加成功!!!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            System.out.println("添加失败!!!");
        }
    }
}
