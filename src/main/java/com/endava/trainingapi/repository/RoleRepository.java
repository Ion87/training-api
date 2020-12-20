package com.endava.trainingapi.repository;

import com.endava.trainingapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

}