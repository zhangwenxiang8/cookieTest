package work.controller;

import work.service.ProductService;
import work.service.ProductServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private ProductService service=new ProductServiceimpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=   Integer.parseInt(req.getParameter("product_id"));
                            //获取 list.jsp页面delete的id值
        service.delete(id);     //用service的删除方法 将获取的指定id记录 逐条删除
      resp.sendRedirect("list");   //每次删除以后返回到主页面.

    }
}
