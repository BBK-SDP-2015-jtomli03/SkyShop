package com.springapp.model;

import sun.security.util.Password;

import java.util.List;

public class CustomerImpl implements Customer {

    private int customerId;
    private String title, forename, surname;
    private Address address;
    private String mobileNumber, landlineNumber, email, login;
    private Password password;
    private boolean emailNotification, smsNotification, emailSpecialOffers, smsSpecialOffers, postSpecialOffers;

    public CustomerImpl(){

    }

    public CustomerImpl(int customerId, String title, String forename, String surname, Address address, String mobileNumber, String landlineNumber, String email, String login, Password password, boolean emailNotification, boolean smsNotification, boolean emailSpecialOffers, boolean smsSpecialOffers, boolean postSpecialOffers) {
        this.customerId = customerId;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
        this.emailSpecialOffers = emailSpecialOffers;
        this.smsSpecialOffers = smsSpecialOffers;
        this.postSpecialOffers = postSpecialOffers;
    }

    public CustomerImpl(String title, String forename, String surname, Address address, String mobileNumber, String landlineNumber, String email, String login, Password password) {
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.emailNotification = false;
        this.smsNotification = false;
        this.emailSpecialOffers = false;
        this.smsSpecialOffers = false;
        this.postSpecialOffers = false;
    }

    public CustomerImpl(String title, String forename, String surname, Address address, String mobileNumber, String landlineNumber, String email, String login, Password password, boolean emailNotification, boolean smsNotification, boolean emailSpecialOffers, boolean smsSpecialOffers, boolean postSpecialOffers) {
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.emailNotification = emailNotification;
        this.smsNotification = smsNotification;
        this.emailSpecialOffers = emailSpecialOffers;
        this.smsSpecialOffers = smsSpecialOffers;
        this.postSpecialOffers = postSpecialOffers;
    }


    // id
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    // title
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // forename
    public String getForename() { return forename; }
    public void setForename(String forename) { this.forename = forename; }

    // surname
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    //address
    public Address getAddress() { return address; }

    @Override
    public String getTitleAndFullName() {
        return null;
    }

    public void setAddress(Address address) { this.address = address; }

    // mobileNumber
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    // landLineNumber
    public String getLandlineNumber() { return landlineNumber; }
    public void setLandLineNumber(String landlineNumber) { this.landlineNumber = landlineNumber; }

    // email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // login
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    // password
    public Password getPassword() { return password; }
    public void setPassword(Password password) { this.password = password; }

    // postSpecialOffers
    public boolean getPostSpecialOffers() { return postSpecialOffers; }
    public void setPostSpecialOffers(boolean postSpecialOffers) { this.postSpecialOffers = postSpecialOffers; }

    // emailNotification
    public boolean getEmailNotification() { return emailNotification; }
    public void setEmailNotification(boolean emailNotification) { this.emailNotification = emailNotification; }

    // smsNotification
    public boolean getSmsNotification() { return smsNotification; }
    public void setSmsNotification(boolean smsNotification) { this.smsNotification = smsNotification; }

    // emailSpecialOffers
    public boolean getEmailSpecialOffers() { return emailSpecialOffers; }
    public void setEmailSpecialOffers(boolean emailSpecialOffers) { this.emailSpecialOffers = emailSpecialOffers; }

    // smsSpecialOffers
    public boolean getSmsSpecialOffers() { return smsSpecialOffers; }
    public void setSmsSpecialOffers(boolean smsSpecialOffers) { this.smsSpecialOffers = smsSpecialOffers; }
}