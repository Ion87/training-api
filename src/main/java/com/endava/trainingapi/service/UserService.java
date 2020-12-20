package com.endava.trainingapi.service;

import com.endava.trainingapi.model.Role;

import java.util.Set;
import java.util.UUID;

public interface UserService {

    void assignRoleToUser(UUID id, Set<Role> roles);

}
