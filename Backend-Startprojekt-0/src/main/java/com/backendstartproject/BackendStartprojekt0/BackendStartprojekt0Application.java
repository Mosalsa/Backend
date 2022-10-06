package com.backendstartproject.BackendStartprojekt0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


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



