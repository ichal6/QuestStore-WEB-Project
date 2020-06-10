import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Example", urlPatterns = "/html-common/cms-header")

public class Example extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name="Przykład";
        request.setAttribute("name", name);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("cms-admin-header.jsp");
        dispatcher.forward(request, response);
    }
}
