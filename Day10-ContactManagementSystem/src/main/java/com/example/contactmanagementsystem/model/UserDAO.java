package com.example.contactmanagementsystem.model;

import com.example.contactmanagementsystem.db.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> findAll() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection connection = DBConnect.getConnection()){
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean addUser(String username, String password) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection connection = DBConnect.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            return preparedStatement.executeUpdate() > 0;
        }  catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
