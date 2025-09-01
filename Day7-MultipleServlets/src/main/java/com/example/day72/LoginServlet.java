package com.example.day72;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private final Map<String, String> map =  new HashMap<>();

    /*LoginServlet() {
        map = new HashMap<>();
        map.put("adem", "admin");
        map.put("efe", "sifre");
    }*/

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (map.containsKey(username) && password.equals(map.get(username))) {
            request.getRequestDispatcher("/welcome-servlet").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error-servlet");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        map.put(username, password);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
    }

    public void destroy() {
    }
}