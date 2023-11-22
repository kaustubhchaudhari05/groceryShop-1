package com.raunak.groceryshop.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.raunak.groceryshop.Entity.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}

