package by.kuzma.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "user", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final Map<String, String> users = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        users.put("User", "User 42");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object sessionAttribute;
        PrintWriter writer = resp.getWriter();
        if(session != null && (sessionAttribute = session.getAttribute("userName")) != null ) {
            writer.print(users.get(sessionAttribute.toString()));
        }else {
            writer.print("user not found");
        }

    }
}
