package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A servlet examples that shows how to handle file upload
 * Works with upload.html
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = "/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(FileUploadServlet.class.getCanonicalName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final String path=getServletContext().getRealPath("/");
        final Part filePart=request.getPart("file");
        final String fileName = getFileName(filePart);
        OutputStream out = null;
        InputStream fileContent = null;
        final PrintWriter writer = response.getWriter();
        try {
            // to get the real file path of web resources
            LOGGER.log(Level.INFO, getServletContext().getRealPath("/"));
            // create the full path name of the file to be stored
            out = new FileOutputStream(new File(path + File.separator + fileName));

            // get the inputstream of uploaded file
            fileContent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            // copy the bytes from inputstream to outputstream
            while ((read = fileContent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            // display the html message on successful file upload
            writer.println("<html><body>");
            writer.println("New file " + fileName + " create at " + path);
            writer.println("<img src='"+fileName+"'/>");
            writer.println("</body></html>");
            LOGGER.log(Level.INFO, "File {0} being uploaded to {1}", new Object[]{fileName, path});

        } catch (FileNotFoundException fne) {
            writer.println("You did not specify a file to upload or specify a protected or nonexistent location");
            writer.println("<br/> ERROR: " + fne.getMessage());
            LOGGER.log(Level.SEVERE, "Problems during file upload.  Error (0)", new Object[]{fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (fileContent != null) {
                fileContent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        // extract the filename from the multi-part stream
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') +1).trim().replace("\"", "");
            }
        }
        return null;

    }
}
