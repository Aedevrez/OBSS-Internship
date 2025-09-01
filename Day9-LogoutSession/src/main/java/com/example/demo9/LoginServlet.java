package com.example.demo9;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final Map<String, String> users = Map.of(
            "adem", "sifre",
            "efe", "sifre2"
    );

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (validateCredentials(username, password)) {
            HttpSession session = request.getSession();

            session.setAttribute("username", username);
            session.setAttribute("loggedIn", true);

            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }

    }

    private boolean validateCredentials(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
