package nd.ermakov.servlet;

import nd.ermakov.servlet.service.AuthService;
import nd.ermakov.servlet.service.AuthStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        AuthStatus authStatus = AuthService.authorize(name, password);
        if (authStatus == AuthStatus.NOT_FOUND) {
            req.getSession().setAttribute("loginMessage", "User " + name + " doesn't exist");
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        if (authStatus == AuthStatus.WRONG_PASSWORD) {
            req.getSession().setAttribute("loginMessage", "Wrong password");
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        req.getSession().setAttribute("name", name);
        resp.sendRedirect(req.getContextPath() + "/welcome");
    }
}
