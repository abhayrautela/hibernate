package com.learn.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "OFFICE_STREET_NAME")
    private String street;
    @Column(name = "OFFICE_CITY_NAME")
    private String city;
    @Column(name = "OFFICE_STATE_NAME")
    private String state;
    @Column(name = "OFFICE_PIN_CODE")
    private String pincode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
