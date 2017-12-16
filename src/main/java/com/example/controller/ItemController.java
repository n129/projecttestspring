package com.example.controller;

import java.sql.Date;
import java.util.Base64;
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

import com.example.entity.Item;
import com.example.service.ItemService;

@CrossOrigin
@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/findItems", 
		produces = MediaType.APPLICATION_JSON_VALUE, 
		method = RequestMethod.GET)
	private ResponseEntity<?> findItem() {
		List <Item> items = itemService.findItems();
	//ITEMS
	items.forEach(a->{
		if(a.getImg01() != null &&a.getImg01().length>0) {
			a.setShowImg01(Base64.getEncoder().encodeToString(a.getImg01()));
			}
	
		if(a.getImg02() != null &&a.getImg02().length>0) {
			a.setShowImg02(Base64.getEncoder().encodeToString(a.getImg02()));
			}
		
		if(a.getImg03() != null &&a.getImg03().length>0) {
			a.setShowImg03(Base64.getEncoder().encodeToString(a.getImg03()));
			}
		});
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saveItem",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.POST)
	private void saveItem(Item item) {
		this.itemService.saveItem(item);
	}
	
	@RequestMapping(value="/deleteItem",
		method=RequestMethod.DELETE)
	private void deleteItem(@RequestBody int id) {
		System.out.println("Deleted Item");
		this.itemService.deleteItem(id);
	}
	@RequestMapping(value = "/getItemsByName",
		produces = MediaType.APPLICATION_JSON_VALUE, 
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByName(@RequestBody String name) {
		List <Item> items = itemService.getItemByName(name);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/getItemsByOwnerUsername",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByOwnerUsername(@RequestBody String ownerUsername) {
		List <Item> items = itemService.getItemByOwnerUsername(ownerUsername);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getItemsByUploadDate",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByDate(@RequestBody Date firstDate, @RequestBody Date secondDate) {
		List <Item> items = itemService.getItemByUploadDate(firstDate, secondDate);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/getItemsByPrice",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByPrice(@RequestBody int firstNumber, @RequestBody int secondNumber) {
		List<Item> items = this.itemService.getItemByPrice(firstNumber, secondNumber);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	/*THESE ARE THE OLD ONES
	 * 
	 * 
	@RequestMapping(value = "/findItems",
		produces = MediaType.APPLICATION_JSON_VALUE, 
		method = RequestMethod.GET)
	private ResponseEntity<?> findItems() {
		List <Item> items = itemService.findItems();
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	@RequestMapping(value = "/getItemsByName",
		produces = MediaType.APPLICATION_JSON_VALUE, 
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByName(@RequestBody String name) {
		List <Item> items = itemService.getItemByName(name);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getItemsByOwnerId",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByOwnerId(@RequestBody Integer ownerId) {
		List <Item> items = itemService.getItemByOwnerId(ownerId);
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/getItemsByUploadDate",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByDate() {
		List <Item> items = itemService.getItemByUploadDate();
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getItemsByUploadDateLatest",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByDateLatest() {
		List <Item> items = itemService.getItemByUploadDateLatest();
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getItemsByLowestPrice",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByLowestPrice() {
		List <Item> items = itemService.getItemByLowestPrice();
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getItemsByHighestPrice",
		produces = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.GET)
	private ResponseEntity<?> getItemByHighestPrice() {
		List <Item> items = itemService.getItemByHighestPrice();
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}
*/
}
