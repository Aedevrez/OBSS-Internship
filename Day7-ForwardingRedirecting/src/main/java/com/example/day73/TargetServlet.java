package com.example.day73;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TargerServlet", value = "/target-servlet")
public class TargetServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String attr = request.getParameter("attr");

        String username = "Null";
        String lastname = "Null";
        if (attr.equals("context")) {
            username = getServletContext().getAttribute("username").toString();
            lastname = getServletContext().getAttribute("lastname").toString();
        } else if (attr.equals("request")) {
            username = request.getAttribute("username").toString();
            lastname = request.getAttribute("lastname").toString();
        }

        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>" + username + ": " + lastname + "</h1>");

    }
}
