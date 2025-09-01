package com.example.day82;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

@WebServlet(name = "timeServlet", value = "/time-servlet")
public class TimeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalTime time = LocalTime.now();
        String timeContent = "<p>Current time is: " + time + "</p>";
        req.setAttribute("timeContent", timeContent);
        resp.setContentType("text/html");
        //PrintWriter out = resp.getWriter();
        //out.println(timeContent);
    }
}
