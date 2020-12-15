package nd.ermakov.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String name = req.getParameter("name");
        if ("admin".equals(name)) {
            request.getSession().setAttribute("signupMessage", "Name admin is reserved");
            response.sendRedirect(request.getContextPath() + "/signup");
            return;
        }
        chain.doFilter(req, resp);
    }
}
