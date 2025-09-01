package com.example.contactmanagementsystem.controller;

import com.example.contactmanagementsystem.model.Contact;
import com.example.contactmanagementsystem.model.ContactDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "UIServlet", value = "/user-interface")
public class UserInterfaceServlet extends HttpServlet {
    private final ContactDAO contactDAO = new ContactDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contact> contacts;
        String query = req.getParameter("content");
        try {
            contacts = contactDAO.findAll(req.getSession().getAttribute("userId").toString());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(contacts);

        if (query != null) {
            List<Contact> fittingContacts = contacts.stream().filter(contact -> contact.getName().contains(query)).toList();
            req.getSession().setAttribute("contacts", fittingContacts);
        } else {
            req.getSession().setAttribute("contacts", contacts);
        }

        req.getRequestDispatcher("/WEB-INF/ui.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        String contact = req.getParameter("contact");

        System.out.println("Mode: " + mode + ", Contact: " + contact);

        req.getSession().setAttribute("contact", contact);
        if (mode.equals("edit")) {
            req.getSession().setAttribute("mode", "edit");
            System.out.println("Edeet");
            //req.getRequestDispatcher("edit").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/edit");
        } else if (mode.equals("delete")) {
            try {
                System.out.println("Delet contact: " + req.getSession().getAttribute("contact"));
                contactDAO.deleteContactById(Integer.valueOf(contact));
                //req.getRequestDispatcher("/WEB-INF/ui.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/user-interface");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (mode.equals("create")) {
            req.getSession().setAttribute("mode", "create");
            System.out.println("Greg");
            resp.sendRedirect(req.getContextPath() + "/edit");
        }
    }
}
