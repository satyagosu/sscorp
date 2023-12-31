package com.sscorp.sscorp.repository;

import com.sscorp.sscorp.Model.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RegisterUserRepository extends MongoRepository<User, User> {

    List<User> findByPhone(String phone);

}
