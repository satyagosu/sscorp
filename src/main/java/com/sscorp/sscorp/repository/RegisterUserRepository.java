package com.sscorp.sscorp.repository;

import com.sscorp.sscorp.Model.RegisterUser;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface RegisterUserRepository extends MongoRepository<RegisterUser, RegisterUser> {


}
