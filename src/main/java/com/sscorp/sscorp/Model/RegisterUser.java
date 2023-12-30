package com.sscorp.sscorp.Model;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "RegisterUser")
public class RegisterUser {
    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String identity;
    public Date dob;
    public UserAddress userAddress;

}
