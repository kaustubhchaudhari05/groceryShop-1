package com.raunak.groceryshop.Repo;

import org.springframework.data.repository.CrudRepository;

import com.raunak.groceryshop.Entity.Roles;

public interface RoleRepository extends CrudRepository <Roles, Long> {

}