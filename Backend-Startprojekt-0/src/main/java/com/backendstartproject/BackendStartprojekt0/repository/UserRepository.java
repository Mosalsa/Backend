package com.backendstartproject.BackendStartprojekt0.repository;

import com.backendstartproject.BackendStartprojekt0.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);
    //User getById(String id);
}
