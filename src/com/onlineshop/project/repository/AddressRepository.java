package com.onlineshop.project.repository;

import com.onlineshop.project.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressRepository {
    private Connection connection;

    public AddressRepository(Connection connection) {
        this.connection = connection;
    }

    public void insertAddress(User user, int user_id) throws SQLException {
        String query = "insert into shop_db.address (state,city,street,postal_code,user_id) " +
                "values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getAddress().getState());
        preparedStatement.setString(2, user.getAddress().getCity());
        preparedStatement.setString(3, user.getAddress().getStreet());
        preparedStatement.setString(4, user.getAddress().getPostalCode());
        preparedStatement.setInt(5, user_id);
        System.out.println("user_id: " + user_id);
        preparedStatement.executeUpdate();
    }
}
