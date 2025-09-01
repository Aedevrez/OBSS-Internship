package com.example.contactmanagementsystem.controller;

import com.example.contactmanagementsystem.model.User;
import com.example.contactmanagementsystem.model.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final UserDAO userDAO =  new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<User> users;
        try {
            users = userDAO.findAll();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (User user : users) {
            if (validateCredentials(user, username, password)) {
                HttpSession session = req.getSession();

                session.setAttribute("userId", user.getId());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("authenticated", "true");
                resp.sendRedirect(req.getContextPath()+"/user-interface");
                return;
            }
        }

        req.setAttribute("error", "invalid");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    private boolean validateCredentials(User user, String username, String password) {
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }
}
