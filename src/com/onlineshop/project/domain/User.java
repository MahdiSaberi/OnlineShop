package com.onlineshop.project.domain;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String password;

    private String username = this.firstName;
    private String phoneNumber;
    private String email;
    private Address address;


    public Address getAddress() {
        return address;
    }

    public void setAddress(int i, int id, String state, String city, String street, String postalCode) {
        this.address = new Address(i, id, state, city, street, postalCode);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = this.firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
