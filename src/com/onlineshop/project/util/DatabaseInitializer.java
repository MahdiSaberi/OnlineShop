package com.onlineshop.project.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private Connection connection;

    public DatabaseInitializer(Connection connection) {
        this.connection = connection;
    }

    public void init() throws SQLException {
        initSchema();
        initProductTable();
        initUserTable();
        initAddressTable();
        initCart();
    }

    public void initSchema() throws SQLException {
        String query = "create schema if not exists shop_db";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    //??
    private void useSelectDatabase() throws SQLException {
        String useSelect = "use management_db";
        Statement statement = connection.createStatement();
        statement.executeUpdate(useSelect);
    }

    public void initUserTable() throws SQLException {
        String query = "CREATE TABLE shop_db.user_table ( " +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "first_name VARCHAR(45) NOT NULL, " +
                "last_name VARCHAR(45) NOT NULL, " +
                "username VARCHAR(45) NOT NULL, " +
                "password VARCHAR(45) NOT NULL, " +
                "phone_number VARCHAR(45) NOT NULL, " +
                "email VARCHAR(45) NOT NULL, " +
                "address VARCHAR(45) NOT NULL, " +
                "PRIMARY KEY (id), " +
                "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE, " +
                "UNIQUE INDEX phone_number_UNIQUE (phone_number ASC) VISIBLE, " +
                "UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE);";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void initAddressTable() throws SQLException {
        String query = "CREATE TABLE shop_db.address ( " +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "state VARCHAR(45) NOT NULL, " +
                "city VARCHAR(45) NOT NULL, " +
                "street VARCHAR(45) NOT NULL, " +
                "postal_code VARCHAR(45) NOT NULL, " +
                "user_id INT NOT NULL, " +
                "PRIMARY KEY (id), " +
                "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE, " +
                "INDEX user_id_fk_idx (user_id ASC) VISIBLE, " +
                "CONSTRAINT user_id_fk " +
                "FOREIGN KEY (user_id) " +
                "REFERENCES shop_db.user_table (id) " +
                "ON DELETE NO ACTION " +
                "ON UPDATE NO ACTION);";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void initProductTable() throws SQLException {
        String query = "CREATE TABLE shop_db.product ( " +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "title VARCHAR(45) NOT NULL, " +
                "available_product INT NOT NULL, " +
                "price INT NOT NULL, " +
                "PRIMARY KEY (id), " +
                "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE);";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void initProducts() throws SQLException {

        String query = "INSERT INTO shop_db.product IF NOT EXISTS" +
                "(id, title, available_product, price) VALUES ('1', 'Sport Shoes', '6', '20'); " +
                "INSERT INTO shop_db.product " +
                "(id, title, available_product, price) VALUES ('2', 'Formal Shoes', '5', '25'); " +
                "INSERT INTO shop_db.product " +
                "(id, title, available_product, price) VALUES ('3', 'Television', '8', '60'); " +
                "INSERT INTO shop_db.product " +
                "(id, title, available_product, price) VALUES ('4', 'Radio', '10', '30'); " +
                "INSERT INTO shop_db.product " +
                "(id, title, available_product, price) VALUES ('5', 'Book', '12', '10'); " +
                "INSERT INTO shop_db.product " +
                "(id, title, available_product, price) VALUES ('6', 'Magazine', '15', '5');";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
    }

    public void initCart() throws SQLException {
        String query = "CREATE TABLE shop_db.cart ( " +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "product_id INT NOT NULL, " +
                "numbers INT NOT NULL, " +
                "user_id INT NOT NULL, " +
                "PRIMARY KEY (id), " +
                "UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE, " +
                "INDEX product_id_fk_idx (product_id ASC) VISIBLE, " +
                "INDEX user_id_fk_cart_idx (user_id ASC) VISIBLE, " +
                "CONSTRAINT product_id_fk " +
                "FOREIGN KEY (product_id) " +
                "REFERENCES shop_db.product (id) " +
                "ON DELETE NO ACTION " +
                "ON UPDATE NO ACTION, " +
                "CONSTRAINT user_id_fk_cart " +
                "FOREIGN KEY (user_id) " +
                "REFERENCES shop_db.user_table (id) " +
                "ON DELETE NO ACTION " +
                "ON UPDATE NO ACTION)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
    }

}