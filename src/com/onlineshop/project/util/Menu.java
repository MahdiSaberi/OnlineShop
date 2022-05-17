package com.onlineshop.project.util;

import com.onlineshop.project.domain.User;
import com.onlineshop.project.repository.ProductRepository;

import java.sql.SQLException;

public class Menu {
    public void showGetUsername() {
        System.out.println("First Name(username):");
    }

    public void showGetLastName() {
        System.out.println("Last Name:");
    }

    public void showGetPassword() {
        System.out.println("password:");
    }

    public void showGetState() {
        System.out.println("State:");
    }

    public void showGetCity() {
        System.out.println("City:");
    }

    public void showGetStreet() {
        System.out.println("Street:");
    }

    public void showGetEmail() {
        System.out.println("Email:");
    }

    public void showGetPhone() {
        System.out.println("Phone Number:");
    }

    public void showGetPostalCode() {
        System.out.println("Postal Code:");
    }

    public void showSuccessfully() {
        System.out.println("Successfully!");
    }

    public void showFailed() {
        System.out.println("Failed!");
    }

    public void showWelcome(User user) {
        System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName());
        System.out.println("==============");
    }

    public void showSelectProduct() {
        System.out.println("Select your Product:");
    }


    public void showProductsList() throws SQLException, ClassNotFoundException {
        System.out.println("Products:");
        ProductRepository productRepository = new ProductRepository();
        productRepository.showGetProducts();
    }

    public void cartMenu() {
        System.out.println("1.add\n2.remove\n3.purchase\n4.exit");
    }

}
