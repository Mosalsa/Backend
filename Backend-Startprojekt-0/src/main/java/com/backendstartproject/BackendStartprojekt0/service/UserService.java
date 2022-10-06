package com.backendstartproject.BackendStartprojekt0.service;

import com.backendstartproject.BackendStartprojekt0.model.Role;
import com.backendstartproject.BackendStartprojekt0.model.User;


import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(String id);

    User saveUser(User user);

    Role saveRole(Role role);

    User updateUser(String id, User user);

    void deleteUser(String id);

    void addRoleToUser(String username, String name);
}
