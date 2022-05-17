package com.onlineshop.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private String url;
    private String user;
    private String pass;
    private Connection connection;

    public DatabaseUtil() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        this.url = "jdbc:mysql://localhost:3306/shop_db";
        this.user = "root";
        this.pass = "9697";

        Properties properties = new Properties();
        properties.put("user", user);
        properties.put("password", pass);
        this.connection = DriverManager.getConnection(url, properties);

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
