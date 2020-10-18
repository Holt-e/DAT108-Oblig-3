import EscapeUtils.StringEscapeUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "HandlelisteServlet", urlPatterns = WebPatterns.HANDLELISTE)
public class HandlelisteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Inn noe kode her i forbindelse med autorisasjon?
        HttpSession sesjon = request.getSession(false);


        if (sesjon != null) {
            // Inn noe kode her i forbindelse med uthenting av sesjonsdata?
            Handleliste cart = (Handleliste) sesjon.getAttribute("cart");

            response.setContentType("text/html; charset=ISO-8859-1");

            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"ISO-8859-1\">");
            out.println("<title>Web Shop</title>");
            out.println("</head>");
            out.println("<body>");

            // Inn noe kode her for "Du er innlogget som <bruker>"?

            out.println("<h2>Min handleliste</h2>");
            out.println("<form action=\"" + "handleliste" + "\" method=\"post\">");
            out.println("<input style=\"margin-right:20px\" type=\"submit\" value=\"Legg til\" />" + "<input type=\"text\" name=\"vareInput\" />");
            out.println("</form>");

            // Inn noe kode her for å vise innhold i handlevogn:
            out.println("<form action=\"" + "handleliste" + "\" method=\"post\">");
            List<HandlelisteItem> list = cart.getItems();
            synchronized (list) {
                for (HandlelisteItem item : list) {
                    out.println("<p>" + "<button style=\"margin-right:20px\" type=\"submit\" value=\"" + item.getItem()
                            + "\" name=\"sletting\"/>slett </button>" + item.getItem() + "</p>");
                }
            }
            out.println("</form>");
            out.println("<button type=\"button\" onclick= \"window.location.href = 'index.jsp'\";>redirect to Index</button>");
            out.println("<button type=\"button\" onclick= \"window.location.href = 'login'\";>redirect to Login</button>");
            out.println("</body>");
            out.println("</html>");
        } else {
            response.sendRedirect("/" + "login" + "?requiresLogin");
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Inn noe kode her i forbindelse med autorisasjon?
        HttpSession sesjon = request.getSession(false);

        if (sesjon == null /*|| sesjon.getAttribute("bruker") == null*/) {
            response.sendRedirect("login" + "?requiresLogin");

        } else {
            // Inn noe kode her i forbindelse med oppdatering av sesjonsdata?
            Handleliste cart = (Handleliste) sesjon.getAttribute("cart");

            if (request.getParameter("sletting") != null) {
                String sletteItemNavn = request.getParameter("sletting");
                HandlelisteItem sletteItem = (HandlelisteItem) sesjon.getAttribute(sletteItemNavn);
                cart.removeItem(sletteItem);
            } else {
                String vareNavn = StringEscapeUtils.escapeHtml(request.getParameter("vareInput"));
                if (!vareNavn.equals("")) {
                    HandlelisteItem newCartItem = new HandlelisteItem(vareNavn);
                    cart.addItem(newCartItem);
                    if (vareNavn != null) {
                        sesjon.setAttribute(vareNavn, newCartItem);
                    }
                }
            }
            response.sendRedirect("handleliste");
        }
    }

}