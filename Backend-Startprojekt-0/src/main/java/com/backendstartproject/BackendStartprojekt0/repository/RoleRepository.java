package com.backendstartproject.BackendStartprojekt0.repository;

import com.backendstartproject.BackendStartprojekt0.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {
    Role findByName(String name);
}
