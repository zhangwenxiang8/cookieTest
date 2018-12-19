package work.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getInitParameter("login"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       System.out.println( req.getParameter("username"));  //测试接收jsp 登入页面 输入值
//        System.out.println( req.getParameter("pwd"));
//        System.out.println( req.getParameter("pwds"));


//        req.getRequestDispatcher("jsp/12.10.jsp").forward(req,resp);//转向
//        resp.sendRedirect("WEB-INF/pages/login.jsp");
        req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req,resp);

    }
}
