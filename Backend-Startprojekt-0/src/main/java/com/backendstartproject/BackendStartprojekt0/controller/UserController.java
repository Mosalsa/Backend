package com.backendstartproject.BackendStartprojekt0.controller;

import com.backendstartproject.BackendStartprojekt0.model.Role;
import com.backendstartproject.BackendStartprojekt0.model.User;
import com.backendstartproject.BackendStartprojekt0.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    public static final Logger log= LoggerFactory.getLogger(UserController.class);
    private final UserService userService;


    @GetMapping("/helloworld")
    public String home(@PathVariable String name){

        return "this is a test controller ";

    }
    @PostMapping("/login")
    public String login(){
        log.info("authentication Api");
        return "user is Successfully authenticate please next sign on with the Token below. ";
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        log.info("userController getusers");
        return userService.getUsers();

    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") String id){
        log.info("userController getUserById {}",id);
        return userService.getUserById(id);
    }

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user){
        log.info("userController saveUser {}",user);
        return userService.saveUser(user);

    }
    @PostMapping("/saverole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        log.info("userController saveRole {}",role);
        return ResponseEntity.ok().body(userService.saveRole(role));

    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") String id,@RequestBody  User user){
        log.info("userController updateUser {} by id {} ",user,id);
        return userService.updateUser(id,user);

    }
    @PostMapping("/addroletouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        log.info("userController addRoleToUser role {} to user {}",form.getName(),form.getUsername());
        userService.addRoleToUser(form.getUsername(),form.getName());
        return ResponseEntity.ok().build();
    }

   @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") String  id){
        log.info("userController deleteUser {} by id ",id);
        userService.deleteUser(id);
        return "user Successfully deleted";
    }




}
