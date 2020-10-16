
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HandlelisteServlet", urlPatterns = WebPatterns.HANDLELISTE)
public class HandlelisteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect(String.format(".%s", WebPatterns.HANDLELISTE));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.getRequestDispatcher("WEB-INF/handleliste.jsp").forward(request, response);
    }

}
