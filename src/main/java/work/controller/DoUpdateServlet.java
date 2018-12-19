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

@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {

private ProductService service=new ProductServiceimpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
       String name =req.getParameter("name");               //将所有类型的数据都强转成字符串类型
       double price =Double.parseDouble(req.getParameter("price"));
        String url=req.getParameter("url");
        String des  =req.getParameter("des");

        Product p=new Product();        //作为容器,装进上面接收的字符串内容
        p.setProductId(id);      //设置新的对象
        p.setProductName(name);
        p.setPrice(price);
        p.setProductDes(des);
        p.setUrl(url);
        service.update(p);     //新的对象执行update方法
        resp.sendRedirect("list"); //修改方法完成后回到主页面
    }
}
