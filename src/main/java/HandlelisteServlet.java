
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HandlelisteServlet", urlPatterns = WebPatterns.HANDLELISTE)
public class HandlelisteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Handleliste liste = new Handleliste();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession sesjon = request.getSession(false);
        if (sesjon == null) {
            System.out.println("Du har vært afk for lenge, sesjon utløpt");
            response.sendRedirect("login");
            return;
        }
        String add = request.getParameter("newItem");
        if (add != null && !add.isEmpty()) {
            liste.add(add);
        }

        String delete = request.getParameter("deleteItem");
        if (delete != null) {
            liste.delete(delete);
        }

        System.out.println("Oppdaterer handlelisten");
        response.sendRedirect("handleliste");
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
        out.println("<form action=\"handleliste\" method=\"post\">");
        out.println("<h3>Min handleliste</h3>");
        out.println("<p><input type=\"submit\" value=\"Legg til\" /><input type=\"text\" name=\"newItem\" /></p>");
        out.println("</form>");

        for (String item : liste.getHandleliste()) {
            out.println("<form action=\"handleliste\" method=\"post\">");
            out.println("<input type=\"hidden\" name=\"deleteItem\" value=\"" + item + "\" />");
            out.println("<input type=\"submit\" value=\"Slett\" />");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }

    }
}