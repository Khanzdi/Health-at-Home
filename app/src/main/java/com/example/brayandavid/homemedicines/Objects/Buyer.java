package com.example.brayandavid.homemedicines.Objects;

/**
 * Created by brayandavid on 20/05/2018.
 */

public class Buyer {

    String contactPhone;
    int dniNumber;
    String emailAddress;
    String fullName;
    String merchantBuyerId;
    shippingAddress shippingAddress;

    public Buyer() {

    }

    public com.example.brayandavid.homemedicines.Objects.shippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(com.example.brayandavid.homemedicines.Objects.shippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(int dniNumber) {this.dniNumber = dniNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMerchantBuyerId() {
        return merchantBuyerId;
    }

    public void setMerchantBuyerId(String merchantBuyerId) {
        this.merchantBuyerId = merchantBuyerId;
    }
}



