package by.kuzma.servlets;

import by.kuzma.service.UserService;
import by.kuzma.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = session.getAttribute("userName").toString();
        resp.getWriter().print(new ObjectMapper().writeValueAsString(userService.getUserByLogin(userName)));
        resp.setStatus(HttpServletResponse.SC_OK);


    }
}
