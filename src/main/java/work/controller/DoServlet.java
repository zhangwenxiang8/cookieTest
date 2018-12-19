package work.controller;

import work.pojo.User;
import work.service.IUserService;
import work.service.UserServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doIt")
public class DoServlet extends HttpServlet {
    private IUserService service=new UserServicelmpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("names");
        String upw = req.getParameter("p");
        String upwd = req.getParameter("ps");
        String tele = req.getParameter("tele");

        User u=new User();
        u.setUsername(uname);
       u.setPassword(upw);
       u.setTele(tele);
       int result =service.insert(u);
       if (result>0){
           resp.getWriter().write("1");
       }else{
           resp.getWriter().write("0");
       }

    }
}
