package com.sscorp.sscorp.Model;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(value = "user",collection = "user")
public class User implements UserId {



    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String identity;
    public Date dob;
    public UserAddress userAddress;




    @Override
    public void setId(String phone) {
        this.id = phone;
    }

    public User(String firstName, String lastName, String email, String phone, String identity, Date dob, UserAddress userAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.identity = identity;
        this.dob = dob;
        this.userAddress = userAddress;
    }

}
