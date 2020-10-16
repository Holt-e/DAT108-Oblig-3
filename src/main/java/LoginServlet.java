import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helpers.InnloggingUtil;
import java.io.IOException;

@WebServlet(name = "LogginnServlet", urlPatterns = WebPatterns.LOGIN)
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String passord = request.getParameter("passord");
        String korrektPassord = getServletConfig().getInitParameter("passord");
        String tidStr = getServletConfig().getInitParameter("innloggingstid");
        int tid = 0;


        //tester om mobil eller passord er tom
        if(passord.isEmpty()); {
            request.setAttribute("feilmelding", "Du må skrive inn et passord. Prøv igjen:");
            response.sendRedirect(String.format(".%s", WebPatterns.LOGIN));

        }if(InnloggingUtil.isGyldigPassord(passord,korrektPassord));{
            InnloggingUtil.loggInnMedTimeout(request,tid);

        }if(!passord.matches(korrektPassord)){
            request.getSession().setAttribute("feilmelding", "Du må skrive inn et passord. Prøv igjen:");
            response.sendRedirect(String.format(".%s", WebPatterns.HANDLELISTE));
        }


        // The URL to send data to (JSP FILE)
        String url = "/login.jsp";

        // NEW Error message to display on the screen
        String errorMsg = "";
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String feilmelding = (String)request.getSession().getAttribute("feilmelding");
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
    }

}

