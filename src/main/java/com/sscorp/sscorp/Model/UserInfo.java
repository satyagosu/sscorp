package com.sscorp.sscorp.Model;
import lombok.Data;

@Data
public class UserInfo {

    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String identity;
    public UserAddress userAddress;


}
