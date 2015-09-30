package com.springapp.model;

import sun.security.util.Password;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerImpl implements Customer{
    private String title;
    private String firstName;
    private String lastName;
    private String usrName;
    private Password password;
    private String email;

    private String address1;
    private String address2;
    private String town;
    private String county;
    private String postcode;

    private boolean emailNotifications;
    private boolean smsNotifications;
    private boolean emailOffers;
    private boolean smsOffers;
    private boolean postOffers;


    public String getFirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public String getTitleAndFullName(){
        return title + " " + firstName + " " + lastName;
    }

    @Override
    public String getAddress(){
        return address1 + " " + address2 + " " + town + " " + county + " " + postcode;
    }
}

