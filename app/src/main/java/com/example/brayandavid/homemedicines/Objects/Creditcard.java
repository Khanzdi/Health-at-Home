package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by brayandavid on 20/05/2018.
 */

public class Creditcard {

    String expirationDate;
    String name;
    String number;
    String securityCode;
    String paymentMethod;
    shippingAddress  shippingAddress;

    public Creditcard() {
    }

    public com.example.brayandavid.homemedicines.Objects.shippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(com.example.brayandavid.homemedicines.Objects.shippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
