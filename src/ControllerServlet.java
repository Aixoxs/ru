import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("x") !=null && request.getParameter("y") != null &&
        request.getParameter("r") != null && request.getParameter("key") != null)
        getServletContext().getNamedDispatcher("AreaCheckServlet").forward(request,response);
        else {
            response.setContentType("text/html;charset=UTF-8");
            response.setStatus(400);
            response.getWriter().println("Invalid data sent");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
