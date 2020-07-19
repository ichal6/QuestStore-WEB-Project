package controller.artefacts;

import DAO.ArtifactDAO;
import DAO.ArtifactJDBCDAO;
import exception.ReadException;
import model.Artifact;
import validation.ValidationHelper;
import validation.ValidationHelperArtifact;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Artifacts-add", urlPatterns = "/artifacts/add")
public class ArtifactAddNewController extends HttpServlet {
    private ArtifactDAO dao;
    private ValidationHelper validationHelper;
    
    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ArtifactJDBCDAO();
        validationHelper = new ValidationHelperArtifact();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/artifacts_add_new.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isInputValid = validationHelper.callInputsValidation(req);
        if(isInputValid){
            try {
                dao.addArtifact(createArtifact(req));
                req.setAttribute("message", "Artifact successfully added!");
            } catch (ReadException e) {
                req.setAttribute("error_message", e.getMessage());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/error_page.jsp");
                dispatcher.forward(req, resp);
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/artifacts_add_new.jsp");
        dispatcher.forward(req, resp);
    }

    private Artifact createArtifact(HttpServletRequest req) {
        int nextAvailableId = dao.getNextAvailableID() + 1;
        String name = req.getParameter("artifact-name");
        String description = req.getParameter("artifact-description");
        int value = Integer.parseInt(req.getParameter("artifact-value"));
        String type = req.getParameter("type-selector");
        String pictureUrl = "artifacts_" + (nextAvailableId) + ".svg";
        return new Artifact(name, description, value, type, pictureUrl);
    }
}
