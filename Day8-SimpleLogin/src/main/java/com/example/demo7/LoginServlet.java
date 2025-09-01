package com.example.demo7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private final Map<String, String> users = Map.of(
            "adem", "sifre",
            "efe", "sifreiki"
    );
    public static final Map<String, String> tokens = new HashMap<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Just forward to login.jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            String token = UUID.randomUUID().toString();
            tokens.put(username, token);

            Cookie userCookie = new Cookie("username", username);
            Cookie tokenCookie = new Cookie("token", token);

            response.addCookie(userCookie);
            response.addCookie(tokenCookie);

            response.sendRedirect(request.getContextPath() + "/welcome-servlet");
        } else {
            request.setAttribute("error", "Invalid credentials");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
