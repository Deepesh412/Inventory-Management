package com.capgemini.inventorymanagement.dao;

import java.util.List;

import com.capgemini.inventorymanagement.entities.Userdata;

public interface UserDao {

	Userdata addUser(Userdata u);


	List<Userdata> getAllUsers();

	Userdata deleteUser(int userId);

	Userdata updateUser(Userdata u);
}
