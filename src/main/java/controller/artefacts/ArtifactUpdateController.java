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

@WebServlet(name = "Artifacts-Update", urlPatterns = "/artifacts/update")

public class ArtifactUpdateController extends HttpServlet {
    ArtifactDAO dao;
    Artifact artifactToEdit;
    int artifactId;
    private ValidationHelper validationHelper;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ArtifactJDBCDAO();
        validationHelper = new ValidationHelperArtifact();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            updateArtifactIdFromRequestIfExists(req);
            artifactToEdit = dao.getArtifactById(artifactId);
            req.setAttribute("artifact", artifactToEdit);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/artifacts_update.jsp");
            dispatcher.forward(req, resp);
        } catch (ReadException e) {
            req.setAttribute("error_message", e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/error_page.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isInputValid = validationHelper.callInputsValidation(req);
        if(isInputValid){
            try {
                dao.updateArtifact(artifactId, createUpdatedArtifact(req));
                req.setAttribute("message", "Artifact successfully edited!");
            } catch (ReadException e) {
                req.setAttribute("error_message", e.getMessage());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/error_page.jsp");
                dispatcher.forward(req, resp);
            }
        }
        doGet(req, resp);
    }

    private Artifact createUpdatedArtifact(HttpServletRequest req) {
        String name = req.getParameter("artifact-name");
        String description = req.getParameter("artifact-description");
        Integer value = Integer.parseInt(req.getParameter("artifact-value"));
        String type = req.getParameter("type-selector");
        return new Artifact(name, description, value, type);
    }

    private void updateArtifactIdFromRequestIfExists(HttpServletRequest request) {
        try {
            artifactId = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            // clause left empty on purpose - if we don't have "id" parameter, the id field already has a value
        }
    }
}
