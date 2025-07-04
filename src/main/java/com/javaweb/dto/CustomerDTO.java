package com.javaweb.dto;

public class CustomerDTO {
    private Long id;
    private Long userAccountId;
    private String name;
    private String phoneNumber;
    private String email;

    public Long getId() {
        return id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
