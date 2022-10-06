package configuration;

import com.backendstartproject.BackendStartprojekt0.controller.UserController;
import com.backendstartproject.BackendStartprojekt0.model.User;
import com.backendstartproject.BackendStartprojekt0.service.UserService;
import com.backendstartproject.BackendStartprojekt0.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.backendstartproject.BackendStartprojekt0")
public class BeanConfig {
 @Bean
public User user(){


    return new User();
}
@Bean
public UserService userService(){


     return new UserServiceImpl();

}
    @Bean
    public UserController controller(){


        return null;
    }


}
