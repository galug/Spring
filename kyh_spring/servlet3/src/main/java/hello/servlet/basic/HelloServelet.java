package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServelet", urlPatterns = "/hello")
public class HelloServelet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello serverlet");
        System.out.println("request : " + req);
        System.out.println("response : " + resp);

        String username = req.getParameter("username");
        System.out.println("name : "+ username);

        resp.setContentType("text/palin");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello " + username);
    }
}
