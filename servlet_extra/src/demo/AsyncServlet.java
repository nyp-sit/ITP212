package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Demo on Asynchrnous processing on Servlet
 *
 */
@WebServlet(name = "AsyncServlet", urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        final AsyncContext aContext = request.startAsync();
        aContext.start(new Runnable() {
            public void run() {
                String param = aContext.getRequest().getParameter("param");
                HttpServletResponse res = (HttpServletResponse) aContext.getResponse();
                for(int i=0; i<10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
//                        res.getWriter().println(i);
                    } catch (Exception e) {

                    }
                }
                try {
//                    response.getWriter().println("Yeah!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                aContext.complete();

            }
        });

        response.getWriter().println("End of Async Servlet!");
        response.getWriter().close();
    }
}
