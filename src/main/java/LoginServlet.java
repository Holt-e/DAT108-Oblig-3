import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = WebPatterns.LOGIN)
public class LoginServlet extends HttpServlet {

    String initpassord;
    int LoggInnTime;

    @Override
    public void init() throws ServletException {
        String initpassord = getServletConfig().getInitParameter("initpassord");
        int LoginTime = Integer.parseInt(getServletConfig().getInitParameter("LoginTime"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Har brukt en request-parameter for aa angi feilmelding

        String feilpassord = request.getParameter("feilpassord");
        String feilmelding = "";
        if(feilpassord != null)
            feilmelding = "<p><font color=\"red\">" + "Passordet du ga inn var feil. Prøv igjen: " + "</font></p> ";

        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");

        //Feilmelding her i forbindelse med feil passord.
        out.println("<p>" + feilmelding + "</p>");

        //vanlig html oppsett med en textbox og en logg inn knapp.
        out.println("<form action=\"" + "login"
                + "\" method=\"post\">");
        out.println("<fieldset>");
        out.println("<legend>Skriv inn passord: </legend>");
        out.println("<input type=\"password\" name=\"password\" />");
        out.println("<p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("<button type=\"button\" onclick= \"window.location.href = 'index.jsp'\";>redirect to Index</button>");
        out.println("</fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String passord = request.getParameter("password");
        String initpassord = getServletConfig().getInitParameter("initpassord");
        int LoginTime = Integer.parseInt(getServletConfig().getInitParameter("LoginTime"));

        if(passord == null || !passord.equals(initpassord)) {
            response.sendRedirect("login" + "?feilpassord");
        }else{

            HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
              //  sesjon.invalidate();
            }else
                sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(LoginTime);

            sesjon.setAttribute("bruker", passord);


            // Inn noe kode her i forbindelse med oppretting av sesjonsdata?
            sesjon.setAttribute("bruker", request.getParameter(passord));
            sesjon.setAttribute("cart" , new Handleliste());
            response.sendRedirect("handleliste");
        }
    }



    }


