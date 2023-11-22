package com.raunak.groceryshop.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.groceryshop.Entity.Roles;
import com.raunak.groceryshop.Service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	public final RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<Roles> getAllRoles() {
        return roleService.getAllRoles();
    }

}
