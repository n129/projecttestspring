package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	private void signup(@RequestBody User user) {
		this.userService.saveUser(user);
	}
	
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	private ResponseEntity<User> login(@RequestBody User u){
		System.out.println("Received: "+u.getUserName()+u.getPassword());
		User user = userService.getUser(u.getUserName(), u.getPassword());
		System.out.println(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/upload/{username}", produces = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	private ResponseEntity<?> upload(@RequestBody MultipartFile image, HttpSession session, Model model, @PathVariable("u_username") String username) {
		System.out.println("HERE!!");
		Files myFile = new Files();
		System.out.println(username);
		try {
			myFile.setPic(image.getBytes());
			myFile.setUsername(username);
			myFile.setPath("C:\\Users\\kopja\\Desktop\\images\\"+image.getOriginalFilename());
			
			System.out.println("File Path "+myFile.getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	userService.save(myFile);
	return new ResponseEntity<HttpStatus>( HttpStatus.OK);
	}*/

}
