package by.kuzma.servlets;

import by.kuzma.service.UserService;
import by.kuzma.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(userService.isUser(login, password)){
            req.getSession().setAttribute("userName", login);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("/user");
        }else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "check login or password");
        }
    }
}
