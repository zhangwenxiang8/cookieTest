package work.controller;

import work.pojo.Product;
import work.service.ProductService;
import work.service.ProductServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doAdd")
public class DoAddServlet extends HttpServlet {


    private ProductService productService=new ProductServiceimpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name= req.getParameter("name");       //将网页输入的值由jsp页面传到controller逻辑处理层
      double price=Double.parseDouble(req.getParameter("price"));
        String des=req.getParameter("des");
        String url=req.getParameter("url");
        Product p = new Product();  //new个对象出来,用servlet的add()方法接收jsp页面传过来的值
        p.setProductName(name);
        p.setPrice(price);
        p.setProductDes(des);
        p.setUrl(url);
        productService.add(p);//点击doAdd添加,此处执行方法
        resp.sendRedirect("list");   //重定向,逻辑处理行为的跳到list.jsp页面
                                        //在add.jsp页面添加完成后,提交进入list表格页面

    }
}
