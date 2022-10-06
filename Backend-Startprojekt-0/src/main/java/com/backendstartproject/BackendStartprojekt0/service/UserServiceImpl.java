package com.backendstartproject.BackendStartprojekt0.service;

import com.backendstartproject.BackendStartprojekt0.model.Role;
import com.backendstartproject.BackendStartprojekt0.model.User;
import com.backendstartproject.BackendStartprojekt0.repository.RoleRepository;
import com.backendstartproject.BackendStartprojekt0.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService,UserDetailsService {
  @Autowired
    private  UserRepository userRepository;
  @Autowired
    private  RoleRepository roleRepository;
  @Autowired
    private  PasswordEncoder passwordEncoder;

    public static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {

        log.info("save new user {} to the Database ",user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public Role saveRole(Role role) {
        log.info("save new role {} to the Database ",role.getName());
        return roleRepository.save(role);
    }
    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("add role {} to user {} ",roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        if(!user.getRoles().contains(role)){
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }
    @Override
    public List<User> getUsers() {
        log.info("get all users from the database");
        return userRepository.findAll();
    }
    @Override
    public User getUserById(String id) {

        return userRepository.findById(id).get();
    }
    @Override
    public void deleteUser(String id) {
        log.info("delete user by id{}", id);
        userRepository.deleteById(id);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userRepository.findByUsername(username);
        if (user == null) {
            log.info("User with username [" + username + "] not found in the database");
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the database");
        }else{
            log.info("user "+ username+" found in the database ");
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<> ();
        user.getRoles ().forEach (role -> {authorities.add (new SimpleGrantedAuthority (role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );

    }
    @Override
    public User updateUser(String id, User user) {

       User tempUser = userRepository.findById(id).get();
        if(Objects.nonNull(tempUser.getUsername())&& "" != tempUser.getUsername()){
            tempUser.setUsername(user.getUsername());
        }
        if(Objects.nonNull(tempUser.getPassword())&& "" != tempUser.getPassword()){
            tempUser.setPassword(user.getPassword());
        }
        if(Objects.nonNull(tempUser.getName())&& "" != tempUser.getName()){
            tempUser.setName(user.getName());
        }
        if(Objects.nonNull(tempUser.getRoles())&& !tempUser.getRoles().isEmpty()){
            tempUser.setRoles(user.getRoles());
        }
        return userRepository.save(tempUser);
    }
}




