package filter;
import exception.SessionException;
import model.CMSUser;
import session.SessionManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthenticationFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            CMSUser user = SessionManager.getActualUser(request);

        } catch (SessionException e) {
            //e.printStackTrace();
            response.sendRedirect("/logout");
        }

//        if (session == null || session.getAttribute("actualUser") == null) {
//            this.context.log("Unauthorized access request");
//            response.sendRedirect(request.getContextPath() + "index.jsp");
//        } else {
            filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
