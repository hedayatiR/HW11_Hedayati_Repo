package com.maktab.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(String telNumber, String mobileNumber) {
        this.telNumber = telNumber;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "telNumber='" + telNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }



}
