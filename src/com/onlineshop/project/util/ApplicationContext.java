package com.onlineshop.project.util;

import com.onlineshop.project.repository.AddressRepository;
import com.onlineshop.project.repository.CartRepository;
import com.onlineshop.project.repository.ProductRepository;
import com.onlineshop.project.repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationContext {
    private AddressRepository addressRepository = null;
    private CartRepository cartRepository = null;
    private ProductRepository productRepository = null;
    private UserRepository userRepository = null;

    private Menu menu = null;
    private DatabaseInitializer databaseInitializer;
    private DatabaseUtil databaseUtil;
    private Scanner intScanner = null;
    private Scanner stringScanner = null;

    public ApplicationContext() throws SQLException, ClassNotFoundException {
        this.databaseUtil = new DatabaseUtil();
        this.databaseInitializer = new DatabaseInitializer(this.databaseUtil.getConnection());

    }

    public AddressRepository getAddressRepository() {
        if (addressRepository == null)
            this.addressRepository = new AddressRepository(databaseUtil.getConnection());
        return addressRepository;
    }

    public CartRepository getCartRepository() {
        if (cartRepository == null)
            this.cartRepository = new CartRepository(databaseUtil.getConnection());
        return cartRepository;
    }

    public ProductRepository getProductRepository() {
        if (productRepository == null)
            this.productRepository = new ProductRepository(databaseUtil.getConnection());
        return productRepository;
    }

    public UserRepository getUserRepository() {
        if (userRepository == null)
            this.userRepository = new UserRepository(databaseUtil.getConnection());
        return userRepository;
    }

    public Menu getMenu() {
        return menu;
    }

    public DatabaseInitializer getDatabaseInitializer() {
        return databaseInitializer;
    }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }

    public Scanner getIntScanner() {
        if (intScanner == null)
            this.intScanner = new Scanner(System.in);
        return intScanner;
    }

    public Scanner getStringScanner() {
        if (stringScanner == null)
            this.stringScanner = new Scanner(System.in);
        return stringScanner;
    }

}
