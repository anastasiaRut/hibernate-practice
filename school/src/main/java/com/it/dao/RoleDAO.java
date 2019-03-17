package com.it.dao;

import com.it.model.Role;

import java.util.List;

public interface RoleDAO extends GenericDAO<Role, Long> {

    Role findRoleWithUsers(String nameOfRole);

    List<Role> findAllWithUsers(Integer firstResult, Integer maxResult);
}