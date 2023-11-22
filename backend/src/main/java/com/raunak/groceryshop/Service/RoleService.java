package com.raunak.groceryshop.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raunak.groceryshop.Entity.Roles;
import com.raunak.groceryshop.Repo.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
    
    public List<Roles> getAllRoles() {
        //List<Roles> roles = (List<Roles>) roleRepository.findAll();
        return (List<Roles>) roleRepository.findAll();
    }
    
}
