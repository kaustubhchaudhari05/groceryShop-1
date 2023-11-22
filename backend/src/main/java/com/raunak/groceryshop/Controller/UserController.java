package com.raunak.groceryshop.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.raunak.groceryshop.Entity.User;
import com.raunak.groceryshop.Service.UserService;
import com.raunak.groceryshop.Service.ValidationService;
import com.raunak.groceryshop.dto.LoginDto;
import com.raunak.groceryshop.dto.UserDto;

import ErrorResponce.ResponseHandler;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ValidationService validationService;

    public UserController(UserService userService, ValidationService validationService) {
        this.userService = userService;
        this.validationService = validationService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
    		
			try {
				validationService.validate(user);
				return userService.createUser1(user); 
			} catch(Exception e) {
				return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
			}

    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto login(@RequestBody LoginDto login ) {
        return userService.login(login);
    }
    
}