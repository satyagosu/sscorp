package com.sscorp.sscorp.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sscorp.sscorp.Model.User;
import com.sscorp.sscorp.Model.UserAddress;
import com.sscorp.sscorp.Model.UserInfo;
import com.sscorp.sscorp.dao.MongoDBConnection;
import com.sscorp.sscorp.repository.RegisterUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Configuration
@Service
public class UserSerivce {

    @Autowired
    private MongoDBConnection mongoDBConnection;

    UserAddress userAddress = new UserAddress();
    @Autowired
    private RegisterUserRepository registerUserRepository;

    public UserInfo userInfo(String phone) {
        UserInfo userInfo = new UserInfo();
        try {
            List<User> existUser = registerUserRepository.findByPhone(phone);
            log.debug("existUser: " + existUser.toString());

            if(!existUser.isEmpty()) {
                userInfo.setFirstName(existUser.get(0).getFirstName());
                userInfo.setLastName(existUser.get(0).getLastName());
                userInfo.setPhone(existUser.get(0).getPhone());
                userInfo.setEmail(existUser.get(0).getEmail());
                userInfo.setIdentity(existUser.get(0).getIdentity());
                UserAddress address = existUser.get(0).getUserAddress();
                userInfo.setUserAddress(address);
            }else {
                log.warn("user not found with the phone#");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }return userInfo;
    }

    public String registerUser(User user) {
        String response = "";
        try {
            if(user !=null && user.getPhone() != null){
               List<User> existUser =registerUserRepository.findByPhone(user.getPhone());
               if(existUser.isEmpty()) {
                   registerUserRepository.save(user);
                   log.info("registered user successfully!!!");
                   response = "registration of user: "+user.getFirstName()+ " with phone: " + user.getPhone() + " is successful!!!";
               } else{
                   log.warn("user" + user.getFirstName() + " already exists: " + user.toString());
                   response = "user already exists with this phone#. try with different phone number";
                   }
            }
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return response;
    }
}
