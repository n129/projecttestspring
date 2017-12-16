package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Plan;
import com.example.service.PlanService;

@CrossOrigin
@RestController
public class PlanController {

	@Autowired
	PlanService planService;

	@RequestMapping(value = "/findPlans",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> findPlans(){
		List <Plan> plans = planService.findPlans();
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
	}

	@RequestMapping(value = "/savePlan",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private void savePlan(Plan plan) {
		this.planService.savePlan(plan);
	}
	
	@RequestMapping(value = "/getPlanByName",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getPlanByName(@RequestBody String name) {
		List <Plan> plans = planService.getPlanByName(name);
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPlanByOwnerUsername",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getPlanbyOwnerUsername(@RequestBody String ownerUsername) {
		List <Plan> plans = planService.getPlanByOwnerUsername(ownerUsername);
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPlanByDate",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getPlanByDate() {
		List <Plan> plans = planService.getPlanByUploadDate();
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getPlanByDateLatest",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getPlanByDateLatest() {
		List <Plan> plans = planService.getPlanByUploadDateLatest();
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
	}
	
}
