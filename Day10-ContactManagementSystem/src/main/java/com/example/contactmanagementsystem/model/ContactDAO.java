package com.example.contactmanagementsystem.model;

import com.example.contactmanagementsystem.db.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public List<Contact> findAll(String userId) throws SQLException, ClassNotFoundException {
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM contacts";

        try (Connection connection = DBConnect.getConnection()){
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                if (resultSet.getInt("user_id") == Integer.parseInt(userId)) {
                    Contact contact = new Contact();
                    contact.setId(resultSet.getInt("id"));
                    contact.setUserId(resultSet.getInt("user_id"));
                    contact.setName(resultSet.getString("name"));
                    contact.setPhoneNumber(resultSet.getString("phone"));
                    contacts.add(contact);
                }
            }
        } catch (SQLException e) {
            System.out.println("reaches here");
            e.printStackTrace();
        }

        return contacts;
    }

    public Contact findContactById(int id) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM contacts WHERE id = ?";
        try (Connection connection = DBConnect.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setUserId(resultSet.getInt("user_id"));
                contact.setName(resultSet.getString("name"));
                contact.setPhoneNumber(resultSet.getString("phone"));
                return contact;
            }
            System.out.println("No data found");
            return null;
        }
    }

    public boolean updateContact(Contact contact) throws SQLException, ClassNotFoundException {
        String query = "UPDATE contacts SET name = ?, phone = ? WHERE id = ?";
        try (Connection connection = DBConnect.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getPhoneNumber());
            preparedStatement.setInt(3, contact.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean deleteContactById(int id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM contacts WHERE id = ?";
        try (Connection connection = DBConnect.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean createContact(String contactName, String contactPhone, String userId) throws SQLException, ClassNotFoundException {
        /*String query = "INSERT INTO contacts VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnect.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, contact.getId());
            preparedStatement.setString(2, userId);
            preparedStatement.setString(3, contact.getName());
            preparedStatement.setString(4, contact.getPhoneNumber());
            return preparedStatement.executeUpdate() > 0;
        }*/
        String query = "INSERT INTO contacts (user_id, name, phone) VALUES (?, ?, ?)";
        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, contactName);
            preparedStatement.setString(3, contactPhone);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
