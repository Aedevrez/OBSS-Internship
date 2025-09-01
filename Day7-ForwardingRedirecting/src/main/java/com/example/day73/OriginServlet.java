package com.example.day73;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class OriginServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String attr = request.getParameter("attr");
        if (attr.equals("request")) {
            requestAttribute(request, response);
        } else if (attr.equals("context")) {
            contextAttribute(request, response);
        }


    }

    private void requestAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "Adem Efe");
        request.setAttribute("lastname", "Devrez");
        String mode = request.getParameter("mode");
        if (mode.equals("forward")) {
            request.getRequestDispatcher("/target-servlet").forward(request, response);
        } else if (mode.equals("redirect")) {
            response.sendRedirect(request.getContextPath() + "/target-servlet?attr=" + request.getParameter("attr"));
        }
    }

    private void contextAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        context.setAttribute("username", "Adem Efe");
        context.setAttribute("lastname", "Devrez");
        String mode = request.getParameter("mode");
        if (mode.equals("forward")) {
            request.getRequestDispatcher("/target-servlet").forward(request, response);
        } else if (mode.equals("redirect")) {
            response.sendRedirect(request.getContextPath() + "/target-servlet?attr=" + request.getParameter("attr"));
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        super.service(req, res);
    }

    public void destroy() {
    }
}