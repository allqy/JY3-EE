package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoImpl;
import com.neuedu.entity.Product;
import com.neuedu.utils.ProductUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = {"/addPro.do","/showAllPro.do"})
//上传文件所需注解
@MultipartConfig
public class ProductServlet extends HttpServlet {
    ProDao proDao;
    @Override
    public void init() throws ServletException {
        proDao=new ProDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String path=request.getServletPath();
        //System.out.println("******************************"+path);
        if(path.equals("/addPro.do")){
            String pro_name=request.getParameter("pro_name");
            String pro_price=request.getParameter("pro_price");
            //得到上传文件的文件名并生成唯一的服务器端文件名
            Part part=request.getPart("pro_img");
            String fileName=ProductUtil.upload(part);

            String pro_des=request.getParameter("pro_des");
            String pro_stock=request.getParameter("pro_stock");
            //得到sql类型的商品日期
            String pro_date=request.getParameter("pro_date");
            Date date=ProductUtil.getDate(pro_date);

            String cate_id=request.getParameter("cate_id");
            String pro_fac=request.getParameter("pro_fac");
            //得到商品ID
            String pro_id=ProductUtil.getProID();
            //System.out.println("*************************8"+pro_id);
            Product product=new Product(pro_id,pro_name,Double.valueOf(pro_price),fileName,pro_des,Short.valueOf(pro_stock),
                    date,Short.valueOf(cate_id),pro_fac);

            boolean result=proDao.addOnePro(product);
            if(result==true){
                request.getRequestDispatcher("showAllPro.do").forward(request,response);
            }else {
                response.sendRedirect("error.jsp");
            }
        }
       else if (path.equals("/showAllPro.do")){
            List<Product> prolist=proDao.queryAllPro();
            System.out.println("*************************8"+prolist.get(0).getPro_fac());
            if(null!=prolist&&prolist.size()>0){
                request.setAttribute("prolist",prolist);
                request.getRequestDispatcher("productlist.jsp").forward(request,response);
            }else {
                response.sendRedirect("error.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
