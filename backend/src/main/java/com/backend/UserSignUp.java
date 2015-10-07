package com.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by kshitij.sharma on 10/6/2015.
 */
@Entity

public class UserSignUp {
    @Id
    String email;

    String username ;
    String password;
    String[] address;
    Long contact_no;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public Long getContact_no() {
        return contact_no;
    }

    public void setContact_no(Long contact_no) {
        this.contact_no = contact_no;
    }
}
