package com.cr1pto.sample.responses;

import java.util.Date;

public class CustomersResponse {
    
    private String name;
    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
