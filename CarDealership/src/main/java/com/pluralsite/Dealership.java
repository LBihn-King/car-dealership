package com.pluralsite;

import java.util.ArrayList;

public class Dealership {
    private String dealerName;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership() {
        this.dealerName = dealerName;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "dealerName='" + dealerName + '|' + ", address='" + address + '|' + ", phone='" + phone + '|' + ", inventory=" + inventory;
    }
}
