package work.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      String username =req.getParameter("username");//获取的jsp页面的name值
//      String password=req.getParameter("pwd");
//      String pas=req.getParameter("pwds");
//      String tele=req.getParameter("tele");
//      System.out.println(username+"    "+password+"    "+pas+"     "+tele);
        //xml初始化映射次servlet后,这里可以接收处值来.

//        resp.sendRedirect("login");     //接收值后(完成注册后) 重定向回到login页面

        req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req,resp);
    }
}
