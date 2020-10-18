
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HandlelisteServlet", urlPatterns = WebPatterns.HANDLELISTE)
public class HandlelisteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Handleliste</title>");
        out.println("</head>");
        out.println("</body>");
        out.println("<form action=\"Handleliste\" method=\"post\">");
        out.println("<h3>Min handleliste</h3>");
        out.println("<p><input type=\"submit\" value=\"Legg til\" /><input type=\"text\" name=\"nyTing\" /></p>");
        out.println("</form>");

            out.println("<form action=\"Handleliste\" method=\"post\">");
            out.println("<input type=\"hidden\" name=\"slettElement\" value=\" \" />");
            out.println("<input type=\"submit\" value=\"Slett\" />");
            out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

}
