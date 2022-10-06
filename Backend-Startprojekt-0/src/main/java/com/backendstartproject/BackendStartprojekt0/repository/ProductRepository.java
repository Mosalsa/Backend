package com.backendstartproject.BackendStartprojekt0.repository;

import com.backendstartproject.BackendStartprojekt0.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    Collection<Product> findByName(String name);
}
