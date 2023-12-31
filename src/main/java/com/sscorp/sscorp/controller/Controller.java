package com.sscorp.sscorp.controller;

import com.sscorp.sscorp.Model.User;
import com.sscorp.sscorp.Model.UserInfo;
import com.sscorp.sscorp.service.UserSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class Controller<user> {

    @Autowired
    UserSerivce userSerivce;

    @GetMapping("/getuser/{phone}")
    @ResponseBody
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String phone){
            
            UserInfo userInfo = new UserInfo();
            userInfo = userSerivce.userInfo(phone);
            if(userInfo != null && userInfo.getFirstName() != null) {
               return ResponseEntity.ok(userInfo);
            }else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
    }

    @PostMapping (value = "/registeruser", consumes = "application/json")
    public String registerUser(@RequestBody User user){
        return userSerivce.registerUser(user);
    }
}