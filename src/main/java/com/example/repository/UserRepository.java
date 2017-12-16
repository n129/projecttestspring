package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	// =: userName will change each time
	@Query("SELECT U FROM User U WHERE userName=:u_username AND password=:u_password")
	public User getUser(@Param("u_username") String userName, @Param("u_password") String password);
	
	@Query("SELECT U FROM User U WHERE userName=:u_username AND password=:u_password")
	public User login(@Param("u_username") String userName, @Param("u_password") String password);
	
}