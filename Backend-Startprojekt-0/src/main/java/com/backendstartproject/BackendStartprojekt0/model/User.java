/**
 *
 *
 *
 *
 **/
package com.backendstartproject.BackendStartprojekt0.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Collection;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
 public static final Logger log= LoggerFactory.getLogger(User.class);
    @Id
    private String id;
    private String name;
    private String username;
    private String password;


    private Collection<Role>roles=new ArrayList<>();

}
