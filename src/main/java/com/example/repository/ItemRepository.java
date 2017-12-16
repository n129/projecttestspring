package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
	@Query("SELECT I FROM Item I WHERE I.name LIKE i_name")
	public List<Item> getItemByName(@Param("i_name") String name);
	
	@Query("SELECT I FROM Item I WHERE I.ownerUsername=:i_ownerusername")
	public List<Item> getItemByOwnerUsername(@Param("i_ownerusername") String ownerUsername);
	
	@Query("SELECT I FROM Item I ORDER BY I.listDate")
	public List<Item> getItemByUploadDate();
	
	@Query("SELECT I FROM Item I ORDER BY I.listDate DESC")
	public List<Item> getItemByUploadDateLatest();
	
	@Query("SELECT I FROM Item I ORDER BY I.price")
	public List<Item> getItemByLowestPrice();

	@Query("SELECT I FROM Item I ORDER BY I.price DESC")
	public List<Item> getItemByHighestPrice();

}
