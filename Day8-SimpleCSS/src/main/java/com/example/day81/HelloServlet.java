package com.example.day81;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String obss = "Go to OBSS";

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>"+ obss +"</title>");
        out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><a href='https://obss.tech' class='link-style'>"+ obss +"</a></p>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
    }
}