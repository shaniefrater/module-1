package com.example.demo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;


public class Airports {

    private int id;
    @Length(min = 5, max = 40)
    private String username;
    @Pattern(regexp = "asd123")
    private String password;
    private String firstname;
    private String lastname;

    public Airports() {
    }

    public int getId() {
        return id;
    }

    public Airports(int id, String username, String password, String firstname, String lastname) {
            this.id =id;
            this.username = username;
            this.password = password;
            this.firstname = firstname;
            this.lastname = lastname;
}

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
