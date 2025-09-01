package com.example.day71;

import java.io.*;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final HashMap<String, String> phoneBook = new HashMap<>();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        boolean retrieve = request.getParameter("retrieve") != null;
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        if (retrieve) {
            String name = request.getParameter("name");
            if (phoneBook.containsKey(name)) {
                out.println("<h1>" + name + ": " + phoneBook.get(name) + "</h1>");

            }
        } else  {
            for (String string : phoneBook.keySet()) {
                out.println("<h1>" + string + ": " + phoneBook.get(string) + "</h1>");
            }
        }

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        phoneBook.put(name, phoneNumber);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (String string : phoneBook.keySet()) {
            out.println("<h1>" + string + ": " + phoneBook.get(string) + "</h1>");
        }
        out.println("</body></html>");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");

        PrintWriter out = response.getWriter();

        if (phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneNumber);
        } else {
            out.println("No record found");
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");

        PrintWriter out = response.getWriter();
        if (phoneBook.containsKey(name)) {
            String phoneNumber = phoneBook.get(name);
            out.println("<h1>" + name + ": " + phoneNumber + "</h1>");
            phoneBook.remove(name);
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        System.out.println("Method: " + request.getMethod());
        super.service(request, response);
    }

    public void destroy() {
    }
}