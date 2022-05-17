package com.onlineshop.project.domain;

public class Address {

    private int id;
    private int user_id;
    private String State;
    private String City;
    private String street;
    private String postalCode;

    public Address(int id, int user_id, String state, String city, String street, String postalCode) {
        this.id = id;
        this.user_id = user_id;
        State = state;
        City = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
