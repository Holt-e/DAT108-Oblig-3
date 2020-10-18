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

    String korrektpass;
    int sekTid;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Sjekker om passordet er riktig
        korrektpass = this.getInitParameter("Passord");
        if (korrektpass.equals(request.getParameter("passord"))) {
            HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
                sesjon.invalidate();
            }

            sesjon = request.getSession(true);
            // Henter tid til inactive fra init paramter i xml-fil
            sekTid = Integer.parseInt(this.getInitParameter("Tid"));
            sesjon.setMaxInactiveInterval(sekTid);

//			sesjon.setAttribute("loggedIn", "yes");


            // Sjekker om det finnes en handlevogn, eller oppretter

            ServletContext servletContext = request.getServletContext();
            if (servletContext.getAttribute("handleliste") == null) {
                //  servletContext.setAttribute("handleliste", new HandlelisteDOA());
            }

            response.sendRedirect("handleliste");
        } else {
            response.sendRedirect("login" + "?feilmelding");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login </title>");
        out.println("</head>");
        out.println("<body>");
        if (request.getParameter("feilmelding") != null) {
            out.println("<p style=\"color:red\">Feil passord. Prøv igjen!</p>");
        }
        out.println("<h3>Skriv inn passord: </h3>");
        out.println("<form name=\"loginForm\" action=\"login\" method=\"post\">");
        out.println("<p><input type=\"password\" name=\"passord\" /></p>");
        out.println("<p><input type=\"submit\" value=\"Logg in\" /></p>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
    }


