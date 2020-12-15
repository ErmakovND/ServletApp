package nd.ermakov.servlet;

import nd.ermakov.servlet.service.AuthService;
import nd.ermakov.servlet.service.AuthStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        AuthStatus authStatus = AuthService.register(name, password);
        if (authStatus == AuthStatus.ALREADY_EXISTS) {
            req.getSession().setAttribute("signupMessage", "User " + name + " already exists");
            resp.sendRedirect(req.getContextPath() + "/signup");
            return;
        }
        req.getSession().setAttribute("loginMessage", "User " + name + " created");
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
