package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Plan;
import com.example.repository.PlanRepository;

//layer between and repository
//browser will know these are all the components
@Service
public class PlanService {

	// makes new object of class and make available at all times - dependency
	// injection
	@Autowired
	PlanRepository planRepository;

	public void savePlan(Plan plan) {
		planRepository.save(plan);
	}

	public List<Plan> findPlans() {
		return planRepository.findAll();
	}
	
	public List<Plan> getPlanByOwnerUsername(String ownerUsername) {
		return planRepository.getPlanByOwnerUsername(ownerUsername);
	}
	
	public List<Plan> getPlanByName(String name) {
		return planRepository.getPlanByName(name);
	}
	
	public List<Plan> getPlanByUploadDate() {
		return planRepository.getPlanByUploadDate();
	}
	
	public List<Plan> getPlanByUploadDateLatest() {
		return planRepository.getPlanByUploadDateLatest();
	}

}