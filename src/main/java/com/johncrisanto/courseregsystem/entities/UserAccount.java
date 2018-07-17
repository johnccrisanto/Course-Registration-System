package com.johncrisanto.courseregsystem.entities;

public class UserAccount {
    private int id;
    private UserDetails userDetails;

    public UserAccount() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
