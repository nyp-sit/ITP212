package demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by chitboon on 8/3/15.
 */
@WebServlet("/scope")
public class Servlet3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestCount = increment(request.getAttribute("count"));
        request.setAttribute("count", requestCount);
        HttpSession session = request.getSession();
        int sessionCount = increment(session.getAttribute("count"));
        session.setAttribute("count", sessionCount);
        ServletContext context = getServletContext();
        int applicationCount = increment(context.getAttribute("count"));
        context.setAttribute("count", applicationCount);
        response.getWriter().println("Request scope count: " + request.getAttribute("count"));
        response.getWriter().println("Session scope count: " + session.getAttribute("count"));
        response.getWriter().println("Application scope count: "+ context.getAttribute("count"));
    }

    private int increment(Object count) {
        if (count != null) {
            return (Integer)count + 1;
        } else {
            return 1;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
