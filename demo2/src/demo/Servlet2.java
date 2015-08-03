package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chitboon on 8/3/15.
 */
@WebServlet(name = "Servlet2", urlPatterns="/multi")
public class Servlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] hobbies = request.getParameterValues("hobby");
        for (int i=0; i<hobbies.length; i++) {
            response.getWriter().println("Hobby " + (i+1) + " : " + hobbies[i]);
        }
    }
}
