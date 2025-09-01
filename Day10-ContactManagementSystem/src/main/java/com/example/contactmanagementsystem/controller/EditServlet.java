package com.example.contactmanagementsystem.controller;

import com.example.contactmanagementsystem.model.Contact;
import com.example.contactmanagementsystem.model.ContactDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    private final ContactDAO contactDAO = new ContactDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getSession().getAttribute("mode").toString();
        if (mode.equals("edit")) {
            int contactId = Integer.valueOf((String) req.getSession().getAttribute("contact"));
            Contact contact;
            try {
                contact = contactDAO.findContactById(contactId);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("contactName", contact.getName());
            req.setAttribute("contactPhone", contact.getPhoneNumber());
            //req.getAttribute("contact");
            req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
        } else if (mode.equals("create")) {
            req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mode = request.getSession().getAttribute("mode").toString();
        if (mode.equals("edit")) {
            int id = Integer.valueOf(request.getSession().getAttribute("contact").toString());
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");

            try {
                Contact updatedContact = new Contact();
                updatedContact.setId(id);
                updatedContact.setName(name);
                updatedContact.setPhoneNumber(phone);
                boolean successful = contactDAO.updateContact(updatedContact);
                if (successful) {
                    response.sendRedirect(request.getContextPath() + "/user-interface");
                }

            } catch (Exception e) {
                request.setAttribute("error", "Error updating contact: " + e.getMessage());
                request.getRequestDispatcher("/user-interface").forward(request, response);
            }
        } else if (mode.equals("create")) {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");

            try {
                contactDAO.createContact(name, phone, request.getSession().getAttribute("userId").toString());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect(request.getContextPath() + "/user-interface");
        }


    }
}
