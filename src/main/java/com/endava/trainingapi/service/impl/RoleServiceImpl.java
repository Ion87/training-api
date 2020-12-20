package com.endava.trainingapi.service.impl;

import com.endava.trainingapi.model.Role;
import com.endava.trainingapi.repository.RoleRepository;
import com.endava.trainingapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Set<Role> getAll() {
        return new HashSet<Role>(roleRepository.findAll());
    }

}
