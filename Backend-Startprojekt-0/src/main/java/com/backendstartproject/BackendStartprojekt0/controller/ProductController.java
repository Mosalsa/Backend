package com.backendstartproject.BackendStartprojekt0.controller;

import com.backendstartproject.BackendStartprojekt0.model.Product;
import com.backendstartproject.BackendStartprojekt0.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;




@RestController
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/create")
    public String createCollection()  {
        productService.createCollection();
        return "Collection is Successfully created";
    }
    @GetMapping("/products")
    public List<Product>findAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/id/{id}")
    public Product findById(@PathVariable("id") String id){
        return productService.findById(id);
    }

    @GetMapping("/products/name/{name}")
    public Collection<Product> findByName(@PathVariable("name") String name){
        return productService.findByName(name);
    }

    @GetMapping("/products/{min}/{max}")
    public List<Product> findBetweenPrice(@PathVariable("min/max")double min,double max ){
        return productService.findBetweenPrice(min,max);
    }



}
