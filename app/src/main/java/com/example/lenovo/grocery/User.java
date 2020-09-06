package com.example.lenovo.grocery;

public class User {
    private String email, phone, password;

    public User(String email, String phone, String password){
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {

        return phone;
    }

    public String getPassword() {
        return password;
    }

}

