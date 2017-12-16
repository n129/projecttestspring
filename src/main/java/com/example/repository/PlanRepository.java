package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
	@Query("SELECT P FROM Plan P WHERE P.name LIKE :p_name")
	public List<Plan> getPlanByName(@Param("p_name") String name);
	
	@Query("SELECT P FROM Plan P WHERE P.ownerUsername =:p_ownerusername")
	public List<Plan> getPlanByOwnerUsername(@Param("p_ownerusername") String ownerUsername);
	
	@Query("SELECT P FROM Plan P ORDER BY P.listDate")
	public List<Plan> getPlanByUploadDate();
	
	@Query("SELECT P FROM Plan P ORDER BY P.listDate DESC")
	public List<Plan> getPlanByUploadDateLatest();

}
