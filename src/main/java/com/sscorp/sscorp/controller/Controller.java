package com.sscorp.sscorp.controller;

import com.sscorp.sscorp.Model.RegisterUser;
import com.sscorp.sscorp.Model.UserInfo;
import com.sscorp.sscorp.repository.RegisterUserRepository;
import com.sscorp.sscorp.service.UserSerivce;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class Controller {

    private RegisterUserRepository registerUserRepository;
    @Autowired
    UserSerivce userSerivce;

    @Autowired
    public Controller(RegisterUserRepository registerUserRepository) {
        this.registerUserRepository = registerUserRepository;
    }

    @GetMapping("/getuser/{phone}")
    @ResponseBody
    public UserInfo getUserInfo(@PathVariable String phone){
       return userSerivce.userInfo(phone);
    }

    @PostMapping("/registeruser/{phone}")
    @RequestBody
    @ResponseBody
    public String registerUser(@PathVariable String phone , @RequestBody RegisterUser registerUser){
        return userSerivce.registerUser(phone , registerUser, registerUserRepository);
    }
}