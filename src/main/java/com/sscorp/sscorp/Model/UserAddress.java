package com.sscorp.sscorp.Model;

import lombok.Data;

@Data
public class UserAddress {

    public String houseNo;
    public String city;
    public String pincode;
    public String state;
    public String country;

    public UserAddress() {
        this.houseNo = houseNo;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
    }

}
