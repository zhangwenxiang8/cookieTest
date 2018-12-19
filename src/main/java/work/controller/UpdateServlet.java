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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private ProductService service=new ProductServiceimpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     int id= Integer.parseInt(req.getParameter("productId")) ; //parseInt()  此方法 字符串转数字
       Product p= service.getOne(id);   //将查询方法执行的id转化为 Product类型 p
        req.setAttribute("p",p);  //与update.jsp里的el表达式 握手链接,将p值传过去
        req.getRequestDispatcher("WEB-INF/pages/update.jsp").forward(req,resp);
                        //执行完方法后重定向回到update.jsp页面
    }
}
