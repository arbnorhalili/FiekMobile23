package com.fiek.helloworld;

public class UserModel {
    int id;
    String name, surname, username;

    public UserModel(int id, String name, String surname, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
