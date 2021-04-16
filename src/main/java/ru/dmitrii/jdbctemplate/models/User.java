package ru.dmitrii.jdbctemplate.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class User {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String first_name;

    @NotEmpty(message = "Adress should not be empty")
    @Size(min = 2, max = 30, message = "Adress should be between 2 and 30 characters")
    private String adress;

    public User() {
    }


    public User(String first_name, int age, String adress) {
        this.first_name = first_name;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "" + getFirst_name() + " " + getAdress();
    }
}
