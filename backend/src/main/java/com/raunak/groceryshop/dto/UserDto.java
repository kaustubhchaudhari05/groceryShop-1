package com.raunak.groceryshop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User Information")
public class UserDto {

    @ApiModelProperty(value = "User ID", example="1")
    private Integer id;

    @ApiModelProperty(value = "Full Name", example="Raunak Agrawal")
    private String fullName;

    @ApiModelProperty(value = "Email ID", example="raunak.agrawal29@gmail.com")
    private String email;

    @ApiModelProperty(value = "Contact Number", example="9876543210")
    private String mobileNo;

    @ApiModelProperty(value = "Gender", example="Male")
    private String gender;
    
    @ApiModelProperty(value = "Role", example="Admin")
    private String role;
    
    @ApiModelProperty(value = "Age", example="29")
    private Integer age;
    @ApiModelProperty(value = "Product Category Name", example="1")
	private String dob;
    
    public UserDto() {
    }



	public UserDto(Integer id, String fullName, String email, String mobileNo, String gender, String role, Integer age,
			String dob) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.role = role;
		this.age = age;
		this.dob = dob;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getGender() {
       return gender;
    }
	public void setGender(String gender) {
		this.gender = gender;
	}
    public String getRole() {
    	return role;
    }
    public void setRole(String role) {
		this.role = role;
	}
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	
}