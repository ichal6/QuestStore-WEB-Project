package filter;
import exception.SessionException;
import model.CMSUser;
import session.SessionManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            CMSUser user = SessionManager.getActualUser(request);
            request.setAttribute("user", user);
        } catch (SessionException e) {
            response.sendRedirect("/logout");
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
