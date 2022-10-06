package com.backendstartproject.BackendStartprojekt0;

import com.backendstartproject.BackendStartprojekt0.controller.UserController;
import com.backendstartproject.BackendStartprojekt0.model.Location;
import com.backendstartproject.BackendStartprojekt0.model.Product;
import com.backendstartproject.BackendStartprojekt0.model.Role;
import com.backendstartproject.BackendStartprojekt0.model.User;
import com.backendstartproject.BackendStartprojekt0.repository.ProductRepository;
import com.backendstartproject.BackendStartprojekt0.service.ProductService;
import com.backendstartproject.BackendStartprojekt0.service.UserService;
import configuration.BeanConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendStartprojekt0Application {

	public BackendStartprojekt0Application() {
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendStartprojekt0Application.class, args);
/*
		ApplicationContext context= new AnnotationConfigApplicationContext(BeanConfig.class);

		UserController userController =context.getBean(UserController.class);
		userController.getUsers();*/


	}

	@Bean
		public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
		}
/*
	@Bean
	CommandLineRunner run(ProductRepository productRepository, MongoTemplate mongoTemplate){


		return args -> {


			String email="test@marcapo.com";

			Product apfel=new Product(email,"Apple", 3.90, LocalDateTime.now(),new Location(10,40));

			Query query=new Query();
			query.addCriteria(Criteria.where("email").is(email));

			List<Product> products =mongoTemplate.find(query,Product.class);

			if(products.size()>4){

				throw new IllegalStateException("found many products with email"+email);
			}
			if(products.isEmpty()){
				System.out.println("insering product");
				productRepository.insert(apfel);

			}else{
				System.out.println(" product already exists");
			}
		};



	}*/





}



