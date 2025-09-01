package com.example.day6dogetapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private ArrayList<Integer> list;
    private Random rand;

    public void init() {
        message = "Random List:";
        list = new ArrayList<>();
        rand = new Random();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        for (Integer integer : list) {
            //out.println(integer);
            out.println("<h4><p>" + integer + "</p></h4>");
        }
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = rand.nextInt(100) + 1;
        list.add(num);
        out.println("Add: " + num);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (list.isEmpty()) {
            out.println("Empty List");
        }  else {
            int oldLast = list.getLast();
            int newLast = rand.nextInt(100) + 1;
            list.removeLast();
            list.add(newLast);
            out.println("Replaced " + oldLast+ " with " + newLast);
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (list.isEmpty()) {
            out.println("Empty List");
        }   else {
            int removed =  list.removeLast();
            out.println("Deleted: " + removed);
        }
    }

    public void destroy() {
    }
}