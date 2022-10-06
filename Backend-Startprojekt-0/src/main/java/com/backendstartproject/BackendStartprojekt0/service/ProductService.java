package com.backendstartproject.BackendStartprojekt0.service;

import com.backendstartproject.BackendStartprojekt0.model.Location;
import com.backendstartproject.BackendStartprojekt0.model.Product;
import com.backendstartproject.BackendStartprojekt0.repository.ProductRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Thread.sleep;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product>getAllProducts( ){

        return productRepository.findAll();
    }
    public Product findById(String id) {
        return productRepository.findById(id).get();
    }
    public Collection<Product> findByName(String name) {
        return productRepository.findByName(name);

    }

    public void createCollection( ) {

    double min = 1;
    double max = 100;
    for(int i=0;i<100000;i++){

        String name = new Faker().food().fruit();
        // String email = new Faker().internet().emailAddress();//Mail
        double random = new Random().nextDouble();
        double price = min + (random * (max - min));//Price
        Location randLocation = new Location(new Random().nextFloat(), new Random().nextFloat());//Location
        Product product = new Product(null,name, price, LocalDateTime.now(), randLocation);

       productRepository.save(product);
    }

    }
    public List<Product> findBetweenPrice(double min, double max) {

    return null;
    }

}
