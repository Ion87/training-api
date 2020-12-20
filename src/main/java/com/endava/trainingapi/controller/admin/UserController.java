package com.endava.trainingapi.controller.admin;

import com.endava.trainingapi.model.Role;
import com.endava.trainingapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "admin/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/{id}/assign-roles")
    @ResponseStatus(HttpStatus.OK)
    public void assignRoleToUser(@Valid @PathVariable("id") UUID id, @RequestBody Set<Role> roles) { 
        userService.assignRoleToUser(id , roles);
    }

}
