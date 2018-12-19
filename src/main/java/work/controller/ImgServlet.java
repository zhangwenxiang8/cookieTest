package work.controller;

import jdk.internal.util.xml.impl.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig //上传文件时用到的标签,比如getPart
@WebServlet("/img")
public class ImgServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part= req.getPart("file");  //获取jsp页面的part文件的name值
            /*文件上传后存储路径和名称*/
        File file=new File("D:\\idea_java_12月份\\_2018_12_19\\src\\main\\webapp\\img\\"+part.getSubmittedFileName());
            /*输出流  向指定位置写数据*/
        OutputStream os=new FileOutputStream(file);//创建一个输出流,转入 此图片文件为对象
        /*文件接收*/
        byte[] bytes=new byte[1024];   //创建一个byte[1024]为单位的对象
       InputStream is =part.getInputStream();//获取一个流 转换为is输入流对象
       int a= is.read(bytes,0,bytes.length);//再byte(只有1k)数组里 读取is对象,从0开始读完全部. 转为a对象(读一次)
        while (a!=-1){
            os.write(bytes);//os写进bytes对象
            a=is.read(bytes,0, bytes.length);   //循环读到完为止
        }


    }
}
