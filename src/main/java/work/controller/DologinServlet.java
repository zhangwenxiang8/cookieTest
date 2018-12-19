package work.controller;

import work.pojo.User;
import work.service.IUserService;
import work.service.UserServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dologin")
public class DologinServlet extends HttpServlet {
    /*
    登陆-- 表单提交
    method get/post
    区别
    get 参数在地址栏上进行拼接
    post  不会再地址栏上拼接 ( 数据包的形式进行传送 )
    post相对安全----表单提交用Post   文件上传file用post
     浏览器的地址栏最多容纳2M

    * */


    private IUserService service = new UserServicelmpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uname = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        User user = service.getOne(uname);
        if (uname != null) {
            if (user.getPassword().equals(pwd)) {

                /*长时间存储*/

                Cookie coo = new Cookie("uname", uname);//设置Cookie 账号密码
                Cookie co = new Cookie("pwd", pwd);
                coo.setMaxAge(60 * 60 * 24 * 7);        //设置最大有效期
                co.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(coo);//存储账号密码到cookie里,响应出去
                resp.addCookie(co);
                HttpSession session =req.getSession();
                session.setAttribute("user",user); //将封装好的账号密码作为一个session对象(k,v值)
                resp.sendRedirect("list");
            }
        }
    }
}
//
//        String username= req.getParameter("username");
//           String password= req.getParameter("pwd");
//           System.out.println(username+"     "+password );
//           User u= service.getOne(username);
//           if (u==null){
//               resp.sendRedirect("register");
//           }else{
//               if (u.getPassword().equals(password)){
//                   resp.sendRedirect("list");
//               }


