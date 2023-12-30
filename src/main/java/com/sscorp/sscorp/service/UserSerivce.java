package com.sscorp.sscorp.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sscorp.sscorp.Model.RegisterUser;
import com.sscorp.sscorp.Model.UserAddress;
import com.sscorp.sscorp.Model.UserInfo;
import com.sscorp.sscorp.dao.MongoDBConnection;
import com.sscorp.sscorp.repository.RegisterUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Slf4j
@Configuration
@Service
public class UserSerivce {

    @Autowired
   private MongoDBConnection mongoDBConnection;
    UserInfo userInfo = new UserInfo();
    UserAddress userAddress = new UserAddress();
    private RegisterUserRepository registerUserRepository;

    public UserInfo userInfo(String phone){

        if(mongoDBConnection==null){
            log.warn("Mongo db connection is null");
             mongoDBConnection.getMongoDBConnection();
        }
        MongoDatabase mongoDatabase =mongoDBConnection.getMongoDBConnection().getDatabase("sscorp");

        MongoCollection<Document> userCollection = mongoDatabase.getCollection("userInfo");
        Document user = userCollection.find(new Document("phone", phone)).first();
        log.debug("user info:" +user.toJson());
        userInfo.setFirstName(user.getString("firstName"));
        userInfo.setLastName(user.getString("lastName"));
        userInfo.setPhone(user.getString("phone"));
        userInfo.setEmail(user.getString("email"));
        userInfo.setIdentity(user.getString("identity"));
        Document address = (Document) user.get("address");
        userAddress.setHouseNo(address.getString("houseNo"));
        userAddress.setCity(address.getString("city"));
        userAddress.setPincode(address.getString("pincode"));
        userAddress.setState(address.getString("state"));
        userAddress.setCountry(address.getString("country"));
        userInfo.setUserAddress(userAddress);
        return userInfo;
    }

    public String registerUser(String phone, RegisterUser registerUser, RegisterUserRepository registerUserRepository) {

        if(mongoDBConnection==null){
            log.warn("Mongo db connection is null");
            mongoDBConnection.getMongoDBConnection();
        }
        try {
            registerUserRepository.save(registerUser);
            log.info("registered user successfully!!!");
        } catch (Exception e){
            log.error(e.getMessage());
        }

        return "registered user successfully!!!";
    }
}
