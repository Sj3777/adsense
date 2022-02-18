package com.example.makemymoney.models;

public class User {
    String name;
    String email;
    String address;
    String dob;
    String username;
    String profilePicture;
    String bio;
    String phoneNumber;
    String token;
    String password;

    public User(String name, String email, String address, String dob, String username, String profilePicture, String bio, String phoneNumber, String token) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.username = username;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.phoneNumber = phoneNumber;
        this.token = token;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
