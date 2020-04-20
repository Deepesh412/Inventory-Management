package com.capgemini.inventorymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.inventorymanagement.entities.Userdata;
import com.capgemini.inventorymanagement.exceptions.IdNotFoundException;
import com.capgemini.inventorymanagement.service.UserService;

@RestController
@RequestMapping("/user")

public class usercontroller {
	@Autowired
	UserService serviceobj;
	//Add user
	@PostMapping("/addUser")
	public ResponseEntity<String>addUser(@RequestBody Userdata u )
	{
		Userdata e = serviceobj.addUser(u);
		if(e == null)
		{
			throw new IdNotFoundException("Enter Valid Id");
		}
		else {
			return new ResponseEntity<String>("User crested successfully",new HttpHeaders(),HttpStatus.OK);		
		}
	}

	//Get all users
	@GetMapping("/GetAllUsers")
	private ResponseEntity<List<Userdata>> getAllUsers() 
	    {
		List<Userdata> userlist = serviceobj.getAllUsers();
		return new ResponseEntity<List<Userdata>>(userlist, new HttpHeaders(), HttpStatus.OK);
        }
	
    //Update User
    @PutMapping("/UpdateUser")
	public ResponseEntity<String> updateUser(@RequestBody Userdata u)
		{
			Userdata e = serviceobj.updateUser(u);
			if (e == null) {
				throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("User updated successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
	// Delete User
	@DeleteMapping("/DeleteUser/{userId}")
	private ResponseEntity<String> deleteUser(@PathVariable("userId") int userId)
		{
			Userdata e = serviceobj.deleteUser(userId);
			if (e == null) {
				throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
			} else {
				return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	

}
