package demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

@WebServlet(name = "SimpleServlet", urlPatterns = "/simple")
public class SimpleServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myName = request.getParameter("name");
        String country[] = request.getParameterValues("countries");
        PrintWriter p = response.getWriter();
        p.println("Your name is : " + myName);
        p.println("You have entered " + country.length + " countries");
    }
}
