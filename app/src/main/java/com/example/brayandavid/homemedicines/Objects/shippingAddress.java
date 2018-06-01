package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by brayandavid on 20/05/2018.
 */

public class shippingAddress {

    String city;
    String country;
    String phone;
    String postalCode;
    String state;
    String street1;
    String street2;
    String user;

    public shippingAddress(String city, String country, String phone, String postalCode, String state, String street1,
                           String street2, String user) {
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.postalCode = postalCode;
        this.state = state;
        this.street1 = street1;
        this.street2 = street2;
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
