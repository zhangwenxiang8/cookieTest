package work.controller;


import work.pojo.Product;
import work.pojo.User;
import work.service.IUserService;
import work.service.ProductService;
import work.service.ProductServiceimpl;
import work.service.UserServicelmpl;
import work.utilTest.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    private ProductService service = new ProductServiceimpl();
    private IUserService userservice = new UserServicelmpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map<String, Cookie> maps = CookieUtil.getCookie(cookies);

        Cookie coo = maps.get("uname");

        String uname = coo.getValue();
        System.out.println(uname);

        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("user");  //封装好的整个对象强转为u

        List<Product> lists = service.getLists();       //整个Product表的查询

        req.setAttribute("list", lists);    //req.转发 将kv值传到Jsp页面才不会乱码(write流或重定向都会造成乱码)
                System.out.println(lists);
        if (u == null) {
            User user = userservice.getOne(uname);
            session.setAttribute("user", user);
            //从service层调过来方法
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        }

    }



}
