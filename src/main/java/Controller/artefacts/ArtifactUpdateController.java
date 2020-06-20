package Controller.artefacts;

import DAO.ArtifactDAO;
import DAO.ArtifactJDBCDAO;
import Model.Artifact;

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

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ArtifactJDBCDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int artifactId = Integer.parseInt(req.getParameterMap().get("id")[0]);
        artifactToEdit = dao.getArtifactById(artifactId);
        req.setAttribute("artifact", artifactToEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html-cms/artifacts_update.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int artifactId = artifactToEdit.getId();
        System.out.println(artifactId);
        String name = req.getParameter("artifact-name");
        String description = req.getParameter("artifact-description");
        Integer value = Integer.parseInt(req.getParameter("artifact-value"));
        String type = req.getParameter("artifact-type");

        Artifact updatedArtifact = new Artifact(name, description, value, type);

        dao.updateArtifact(artifactId, updatedArtifact);

        resp.sendRedirect("/artifacts");
    }


}
