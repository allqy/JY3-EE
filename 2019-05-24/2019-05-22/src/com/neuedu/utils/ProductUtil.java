package com.neuedu.utils;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

public class ProductUtil {
    //随机生成商品ID
    public static String getProID(){
        String proID=null;
        Long time=System.currentTimeMillis();
        Random random=new Random();
        int i=random.nextInt(100);
        if(i<10){
            proID=String.valueOf(time)+"_"+"0"+i;
        }else {
            proID=String.valueOf(time)+"_"+i;
        }
        return proID;
    }

    //文件上传并将上传的文件转换成一个唯一的文件名作为服务器文件名并且作为函数返回值
    public static String upload(Part part){
        String oriFileName=part.getSubmittedFileName();
        String finalFileName=UUID.randomUUID()+"_"+oriFileName;
        try {
            InputStream is=part.getInputStream();
            OutputStream os=new FileOutputStream("D:\\idea\\uploadImg\\"+finalFileName);
            int len=0;
            byte[] b=new byte[1024];
            while ((len=is.read(b))!=-1){
                os.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalFileName;
    }

    public static Date getDate(String dateStr){
        Date date=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            //将字符串类型的日期转化成util包下的日期类型
            java.util.Date utilDate=simpleDateFormat.parse(dateStr);
            //得到日期对应的毫秒值
            Long time =utilDate.getTime();
            //将毫秒值转化成sql类型的日期
            date=new Date(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
