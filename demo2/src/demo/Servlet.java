package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chitboon on 7/31/15.
 */
@WebServlet(name = "Servlet", urlPatterns = "/myFirstServlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("name");
        String gender = request.getParameter("gender");
        String java = request.getParameter("java");
        response.getWriter().println("Hello " + user);
        response.getWriter().println("You have selected " + gender + " as your gender.");
        response.getWriter().println("You have a " + java + " personality.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello ITP212");
    }
}
