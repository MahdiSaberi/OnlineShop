package com.onlineshop.project.repository;

import com.onlineshop.project.domain.User;

import java.sql.*;

public class UserRepository {
    private User user;
    private ResultSet resultSet;
    private Connection connection;
    private int user_id;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public void insertUser(User user) throws SQLException {
        String query = "insert into shop_db.user_table(first_name,last_name,username,password,phone_number,email) " +
                "values(?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getPhoneNumber());
        preparedStatement.setString(6, user.getEmail());
        //preparedStatement.setString(7,user.getAddress[]());
        preparedStatement.executeUpdate();

    }

    public boolean checkUser(User user) throws SQLException {
        boolean userIn = false;

        String query = "select username, password from shop_db.user_table";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            //System.out.println("ok");
            if (resultSet.getString("username").equals(user.getUsername())
                    && resultSet.getString("password").equals(user.getPassword())) {
                userIn = true;
            }

        }
        return userIn;
    }


}
