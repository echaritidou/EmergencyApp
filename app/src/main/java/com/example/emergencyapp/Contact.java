package com.example.emergencyapp;

public class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoeNumber) {
        this.name = name;
        this.phoneNumber = phoeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
