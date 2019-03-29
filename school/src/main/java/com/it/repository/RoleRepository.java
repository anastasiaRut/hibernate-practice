package com.it.repository;

import com.it.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("FROM Role role JOIN FETCH role.users WHERE role.name = :name")
    Role findRoleWithUsers(@Param("name") String nameOfRole);

    @Query("FROM Role role JOIN FETCH role.users")
    List<Role> findAllWithUsers();


}