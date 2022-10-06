package com.backendstartproject.BackendStartprojekt0.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@Builder
public class Product {


    @Id
    private String id;
    private String name;
    private double price;
    private LocalDateTime created;
   private Location location;

    public Product(String id, String name, double price, LocalDateTime created, Location location) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.created = created;
        this.location = location;
    }
}

