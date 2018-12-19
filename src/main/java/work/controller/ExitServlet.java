package work.controller;


import work.utilTest.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

public class ExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Cookie[] cookies =req.getCookies();
          Map<String,Cookie> map =CookieUtil.getCookie(cookies);
            Cookie c=map.get("uname");
            Cookie coo=new Cookie("uname","");
            coo.setMaxAge(0);
            resp.addCookie(coo);
           HttpSession session =req.getSession();
           session.invalidate();
           resp.sendRedirect("login");
    }
}
