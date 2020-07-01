package filter;
import exception.SessionException;
import model.CMSUser;
import session.SessionManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RoleFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        CMSUser user = (CMSUser) request.getAttribute("user");

        if(user == null){
            response.sendRedirect("/logout");
        }
        
        if(!user.isAdmin()){
            response.sendRedirect("/dashboard");
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}