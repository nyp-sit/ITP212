package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hellow Servlet Post!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("Hello Servlet Get!");

        StringBuilder s = new StringBuilder();

        s.append("<table border='1'>");
        s.append("<tr><td>hello</td><td>world</td></tr>");
        s.append("<tr><td>foo</td><td>bar</td></tr>");

        response.getWriter().println(s.toString());

    }
}
