package com.endava.trainingapi.service.impl;

import com.endava.trainingapi.exceptions.AppEntityNotFoundException;
import com.endava.trainingapi.model.Role;
import com.endava.trainingapi.model.User;
import com.endava.trainingapi.repository.UserRepository;
import com.endava.trainingapi.service.RoleService;
import com.endava.trainingapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    @Override
    public void assignRoleToUser(UUID id, Set<Role> roles) {
        Optional<User> userDB = userRepository.findById(id);
        Set<Role> rolesDB =  roleService.getAll();
        User user;

        if (userDB.isPresent()) {
            user = userDB.get();
            Set<Role> validRoles = selectOnlyValidRoles(roles, rolesDB);

            addRolesToUser(user,validRoles);
            userRepository.save(user);
        }else {
            throw new AppEntityNotFoundException(String.format("User %s npt found.", id.toString()));
        }
    }

    private Set<Role> selectOnlyValidRoles(Collection<Role> collection, Collection<Role> validRoles){

        return collection.stream()
                .filter(validRoles::contains)
                .collect(Collectors.toSet());
    }

    public void addRolesToUser(User user, Set<Role> roles) {

        Set<Role> userRoles = user.getRoles();

        for (Role role : roles) {
            if (!userRoles.contains(role)) {
                user.getRoles().add(role);
            }
        }
    }

}
