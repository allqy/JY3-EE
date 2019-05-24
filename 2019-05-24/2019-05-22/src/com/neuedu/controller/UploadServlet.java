package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload.do")
//文件上传所需注解
@MultipartConfig
public class UploadServlet extends HttpServlet {
    String[] filePatternsArr={"png","jpg","svg","gif","bmp"};
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part=request.getPart("uploadfile");
        String oriFileName=part.getSubmittedFileName();
        boolean result=checkImgPattern(filePatternsArr,oriFileName);
        if(result==true){
            InputStream is=part.getInputStream();
            String newFileName=getFileName(oriFileName);
            OutputStream os=new FileOutputStream("D:\\idea\\uploadImg\\"+newFileName);
            int len=0;
            byte[] b=new byte[1024];
            while ((len=is.read(b))!=-1){
                os.write(b,0,len);
            }
        }else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //限制上传文件的格式
    boolean checkImgPattern(String[] filePatternsArr,String fileName){
        boolean result=false;
        String pattern=fileName.substring(fileName.lastIndexOf(".")+1);
        for(String str:filePatternsArr){
            if ((str.equals(pattern))){
                result=true;
                return result;
            }
        }
        return result;
    }
    //防止文件名字重复
    String getFileName(String oriFileName){
        String filename=null;
        filename=UUID.randomUUID()+"_"+oriFileName;
        return filename;
    }
}
