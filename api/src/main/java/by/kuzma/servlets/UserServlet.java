package by.kuzma.servlets;

import by.kuzma.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private transient UserService userService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object sessionAttribute;
        PrintWriter writer = resp.getWriter();
        if (session != null && (sessionAttribute = session.getAttribute("userName")) != null) {
            resp.setStatus(200);
            writer.print(userService.getUserByLogin(sessionAttribute.toString()));
        } else {
            resp.setStatus(404);
            writer.print(resp.getStatus() + "  user not found");
        }

    }
}
