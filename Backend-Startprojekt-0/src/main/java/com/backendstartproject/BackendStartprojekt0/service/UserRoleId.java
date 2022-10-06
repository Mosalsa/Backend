package com.backendstartproject.BackendStartprojekt0.service;

import com.backendstartproject.BackendStartprojekt0.model.Role;
import com.backendstartproject.BackendStartprojekt0.model.User;
import com.backendstartproject.BackendStartprojekt0.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@Data
@RequiredArgsConstructor
public class UserRoleId {


    private UserRepository userRepository;
    private String user_id;
    private Collection<Role> roles;

    public UserRoleId(String user_id, Collection<Role> roles) {
        this.user_id = user_id;
        this.roles = roles;
    }

    public void deleteUserRoleId(String user_id, Collection<Role> roles){
   User user = userRepository.findById(user_id).get();
        roles=user.getRoles();
        roles.removeAll(roles);
        user.setRoles(roles);
}

}
