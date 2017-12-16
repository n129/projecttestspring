package com.example.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.repository.ItemRepository;

//layer between and repository
//browser will know these are all the components
@Service
public class ItemService {

	private Connection connection;
	// makes new object of class and make available at all times - dependency
	// injection
	@Autowired
	ItemRepository itemRepository;

	public void saveItem(Item item) {
		itemRepository.save(item);
	}

	public List<Item> findItems() {
		return itemRepository.findAll();
	}
	
	public List<Item> getItemByOwnerUsername(String inputOwnerUsername) {
		List<Item> items = new ArrayList<>();
		
		try{
			//My SQL Select Query
			String getQueryStatement = "SELECT I FROM item I WHERE I.name LIKE i_name";
			PreparedStatement preparedStatement = connection.prepareStatement(getQueryStatement);
			//LOOK AT THIS LAMAR
			preparedStatement.setString(1, inputOwnerUsername);
			
			//Pull data
			ResultSet rs = preparedStatement.executeQuery();
			//Iterate through the java ResultSet
			while (rs.next()) {
				int id = rs.getInt("i_id");
				String name = rs.getString("i_name");
				String discription = rs.getString("i_description");
				double price = rs.getDouble("i_price");
				String ownerUsername = rs.getString("i_ownerusername");
				Timestamp listDate = rs.getTimestamp("i_listdate");
				String status = rs.getString("i_status");
				boolean isTool = rs.getBoolean("i_isTool");
				String soldTo = rs.getString("i_soldto");
				Timestamp soldToDate = rs.getTimestamp("i_soldtodate");
				Date rentStartDate = rs.getDate("i_rentstartdate");
				Date rentEndDate = rs.getDate("i_rentenddate");
				String rentTo = rs.getString("i_rentto");
				byte[] img01 = rs.getBytes("i_img01");
				String img01descript = rs.getString("i_img01descript");
				byte[] img02 = rs.getBytes("i_img02");
				String img02descript = rs.getString("i_img02descript");
				byte[] img03 = rs.getBytes("i_img03");
				String img03descript = rs.getString("i_img03descript");
				
			//add the customer record to a list, return list
				/*Item item = new Item(id,name,discription,price,
					ownerUsername,listDate,status,isTool,soldTo,soldToDate,
					rentStartDate,rentEndDate,rentTo,img01,img01descript,
					img02,img02descript,img03,img03descript);
				items.add(item);*/
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public List<Item> getItemByName(String inputName) {
		List<Item> items = new ArrayList<>();
		
		try{
			//My SQL Select Query
			String getQueryStatement = "SELECT I FROM item I WHERE I.name LIKE i_name";
			PreparedStatement preparedStatement = connection.prepareStatement(getQueryStatement);
			
			preparedStatement.setString(1, inputName);
			
			//Pull data
			ResultSet rs = preparedStatement.executeQuery();
			//Iterate through the java ResultSet
			while (rs.next()) {
				int id = rs.getInt("i_id");
				String name = rs.getString("i_name");
				String discription = rs.getString("i_description");
				double price = rs.getDouble("i_price");
				String ownerUsername = rs.getString("i_ownerusername");
				Timestamp listDate = rs.getTimestamp("i_listdate");
				String status = rs.getString("i_status");
				boolean isTool = rs.getBoolean("i_isTool");
				String soldTo = rs.getString("i_soldto");
				Timestamp soldToDate = rs.getTimestamp("i_soldtodate");
				Date rentStartDate = rs.getDate("i_rentstartdate");
				Date rentEndDate = rs.getDate("i_rentenddate");
				String rentTo = rs.getString("i_rentto");
				byte[] img01 = rs.getBytes("i_img01");
				String img01descript = rs.getString("i_img01descript");
				byte[] img02 = rs.getBytes("i_img02");
				String img02descript = rs.getString("i_img02descript");
				byte[] img03 = rs.getBytes("i_img03");
				String img03descript = rs.getString("i_img03descript");
				
			//add the customer record to a list, return list
				/*Item item = new Item(id,name,discription,price,
					ownerUsername,listDate,status,isTool,soldTo,soldToDate,
					rentStartDate,rentEndDate,rentTo,img01,img01descript,
					img02,img02descript,img03,img03descript);
				items.add(item);*/
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public List<Item> getItemByUploadDate(Date firstDate, Date secondDate) {
		List<Item> items = new ArrayList<>();
		
		try{
			//My SQL Select Query
			String getQueryStatement = "SELECT * FROM item WHERE listDate BETWEEN ? AND ?";
			PreparedStatement preparedStatement = connection.prepareStatement(getQueryStatement);
			
			preparedStatement.setDate(1, firstDate);
			preparedStatement.setDate(2, secondDate);
			//Pull data
			ResultSet rs = preparedStatement.executeQuery();
			//Iterate through the java ResultSet
			while (rs.next()) {
				int id = rs.getInt("i_id");
				String name = rs.getString("i_name");
				String discription = rs.getString("i_description");
				double price = rs.getDouble("i_price");
				String ownerId = rs.getString("i_ownerid");
				Timestamp listDate = rs.getTimestamp("i_listdate");
				String status = rs.getString("i_status");
				boolean isTool = rs.getBoolean("i_isTool");
				String soldTo = rs.getString("i_soldto");
				Timestamp soldToDate = rs.getTimestamp("i_soldtodate");
				Date rentStartDate = rs.getDate("i_rentstartdate");
				Date rentEndDate = rs.getDate("i_rentenddate");
				String rentTo = rs.getString("i_rentto");
				byte[] img01 = rs.getBytes("i_img01");
				String img01descript = rs.getString("i_img01descript");
				byte[] img02 = rs.getBytes("i_img02");
				String img02descript = rs.getString("i_img02descript");
				byte[] img03 = rs.getBytes("i_img03");
				String img03descript = rs.getString("i_img03descript");
				
			//add the customer record to a list, return list
				/*Item item = new Item(id,name,discription,price,
					ownerId,listDate,status,isTool,soldTo,soldToDate,
					rentStartDate,rentEndDate,rentTo,img01,img01descript,
					img02,img02descript,img03,img03descript);
				items.add(item);*/
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public List<Item> getItemByPrice(int firstNumber, int secondNumber) {
		List<Item> items = new ArrayList<>();
		
		try{
			//My SQL Select Query
			String getQueryStatement = "SELECT * FROM item WHERE price BETWEEN ? AND ?";
			PreparedStatement preparedStatement = connection.prepareStatement(getQueryStatement);
			
			preparedStatement.setInt(1, firstNumber);
			preparedStatement.setInt(2, secondNumber);
			//Pull data
			ResultSet rs = preparedStatement.executeQuery();
			//Iterate through the java ResultSet
			while (rs.next()) {
				int id = rs.getInt("i_id");
				String name = rs.getString("i_name");
				String discription = rs.getString("i_description");
				double price = rs.getDouble("i_price");
				String ownerId = rs.getString("i_ownerid");
				Timestamp listDate = rs.getTimestamp("i_listdate");
				String status = rs.getString("i_status");
				boolean isTool = rs.getBoolean("i_isTool");
				String soldTo = rs.getString("i_soldto");
				Timestamp soldToDate = rs.getTimestamp("i_soldtodate");
				Date rentStartDate = rs.getDate("i_rentstartdate");
				Date rentEndDate = rs.getDate("i_rentenddate");
				String rentTo = rs.getString("i_rentto");
				byte[] img01 = rs.getBytes("i_img01");
				String img01descript = rs.getString("i_img01descript");
				byte[] img02 = rs.getBytes("i_img02");
				String img02descript = rs.getString("i_img02descript");
				byte[] img03 = rs.getBytes("i_img03");
				String img03descript = rs.getString("i_img03descript");
				
				//add the customer record to a list, return list
				/*Item item = new Item(id,name,discription,price,
					ownerId,listDate,status,isTool,soldTo,soldToDate,
					rentStartDate,rentEndDate,rentTo,img01,img01descript,
					img02,img02descript,img03,img03descript);
				items.add(item);	*/
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	
	public void deleteItem(int id){
		//List<Customer> customers = new ArrayList<>();
		try {
			String deleteQueryStatement = "DELETE FROM item WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQueryStatement);
			
			preparedStatement.setInt(1, id);
			//execute delete SQL statement
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*THESE ARE THE GOOD ONES
	 * 
	public List<Item> getItemByOwnerId(Integer ownerId) {
		return itemRepository.getItemByOwnerId(ownerId);
	}
	
	public List<Item> getItemByName(String name) {
		return itemRepository.getItemByName(name);
	}
	
	public List<Item> getItemByUploadDate() {
		return itemRepository.getItemByUploadDate();
	}
	
	public List<Item> getItemByUploadDateLatest() {
		return itemRepository.getItemByUploadDateLatest();
	}
	
	public List<Item> getItemByLowestPrice() {
		return itemRepository.getItemByLowestPrice();
	}
	
	public List<Item> getItemByHighestPrice() {
		return itemRepository.getItemByHighestPrice();
	}*/
}