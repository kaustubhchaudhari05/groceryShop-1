package com.raunak.groceryshop.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raunak.groceryshop.Entity.User;
import com.raunak.groceryshop.Repo.UserRepository;
import com.raunak.groceryshop.dto.LoginDto;
import com.raunak.groceryshop.dto.UserDto;

import ErrorResponce.ResponseHandler;

@Service
public class UserService {
    
    private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public UserDto createUser(UserDto userDto) {
	    	
	        User user = new User();
	        user.setId(userDto.getId());
	        User savedUser = userRepository.save(user);
	
	        UserDto savedUserDto = new UserDto();
	        savedUserDto.setId(savedUser.getId());
	        return savedUserDto;
	    }
	    
	    public ResponseEntity<Object> createUser1(User user) {
	    	User emailExists = userRepository.findByEmail(user.getEmail());
	    	if (emailExists != null) {
	    		return ResponseHandler.generateResponse("This Email is already registered.", HttpStatus.MULTI_STATUS, null);
            } else {
	        User u = new User();
	        u.setEmail(user.getEmail());
	        u.setDob(user.getDob());
	        u.setFirstName(user.getFirstName());
	        u.setLastName(user.getLastName());
	        u.setGender(user.getGender());
	        u.setRole(user.getRole());
	        u.setPassword(user.getPassword());
	        u.setMobileNo(user.getMobileNo());
	        User savedUser = userRepository.save(u);
	        UserDto userDto = convertToUserDto(savedUser);
	        return ResponseHandler.generateResponse("Sucessfully Registered", HttpStatus.OK, userDto);
            }
	    }
	    
	    public UserDto login(LoginDto login) {
	    	User user = userRepository.findByEmail(login.getEmail());
	    	if(user == null) {
	    		return null;
	    	}
	    	String userPassword = user.getPassword();
	    	String loginPassword = login.getPassword();
	    	
	    	if(loginPassword.equals(userPassword)) {
	    	UserDto userDto = convertToUserDto(user);
	    		return userDto;
	    	}else {
	    		return null;
	    	}
	    }
    
	    public List<UserDto> getAllUsers() {
	        List<User> users = (List<User>) userRepository.findAll();
	        List<UserDto> userDtos = new ArrayList<>();
	
	        for (User user : users) {
	            UserDto userDto = convertToUserDto(user);
	            userDtos.add(userDto);
	        }
	
	        return userDtos;
	    }
	
	    private UserDto convertToUserDto(User user) {
	        UserDto userDto = new UserDto();
	        userDto.setId(user.getId());
	        userDto.setFullName(user.getFirstName() + " " + user.getLastName());
	        userDto.setEmail(user.getEmail());
	        userDto.setMobileNo(user.getMobileNo());
	        userDto.setDob(user.getDob());
			LocalDate da = LocalDate.parse(user.getDob());
			LocalDate curDate = LocalDate.now();  
			Integer age = Period.between(da, curDate).getYears();
			userDto.setAge(age);
			
	        if ("1".equals(user.getRole())) {
	            userDto.setRole("Admin");
	        } else if ("2".equals(user.getRole())) {
	        	userDto.setRole("Employee");
	        } else {
	        	userDto.setRole("Customer");
	        }
	        
	        if ("m".equals(user.getGender())) {
	        	userDto.setGender("Male");
	        } else {
	        	userDto.setGender("Female");
	        }
	        
	        return userDto;
	    }
	    
	    
}