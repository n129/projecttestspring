package com.example.entity;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="item")
public class Item {
	@Id
	@Column(name="i_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="i_name")
	private String name;
	@Column(name="i_description")
	private String description;
	@Column(name="i_price")
	private double price;
	@Column(name="i_ownerusername")
	private String ownerUsername;
	@CreationTimestamp
	@Column(name="i_listdate")
	private Timestamp listDate;
	@Column(name="i_status")
	private String status;
	@Column(name="i_istool")
	private boolean isTool;
	@Column(name="i_soldto")
	private String soldTo;
	@Column(name="i_soldtodate")
	private Timestamp soldToDate;
	@Column(name="i_rentstartdate")
	private Date rentStartDate;
	@Column(name="i_returndate")
	private Date rentReturnDate;
	@Column(name="i_rentto")
	private String rentto;
	@Column(name="i_img01")
	private byte[] img01;
	@Column(name="i_img01descript")
	private String img01Descript;
	@Column(name="i_img02")
	private byte[] img02;
	@Column(name="i_img02descript")
	private String img02Descript;
	@Column(name="i_img03")
	private byte[] img03;
	@Column(name="i_img03descript")
	private String img03Descript;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public void setOwnerId(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}
	public Timestamp getListDate() {
		return listDate;
	}
	public void setListDate(Timestamp listDate) {
		this.listDate = listDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isTool() {
		return isTool;
	}
	public void setTool(boolean isTool) {
		this.isTool = isTool;
	}
	public String getSoldTo() {
		return soldTo;
	}
	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}
	public Timestamp getSoldToDate() {
		return soldToDate;
	}
	public void setSoldToDate(Timestamp soldToDate) {
		this.soldToDate = soldToDate;
	}
	public Date getRentStartDate() {
		return rentStartDate;
	}
	public void setRentStartDate(Date rentStartDate) {
		this.rentStartDate = rentStartDate;
	}
	public Date getRentReturnDate() {
		return rentReturnDate;
	}
	public void setRentReturnDate(Date rentReturnDate) {
		this.rentReturnDate = rentReturnDate;
	}
	public String getRentto() {
		return rentto;
	}
	public void setRentto(String rentto) {
		this.rentto = rentto;
	}
	public byte[] getImg01() {
		return img01;
	}
	public void setImg01(byte[] img01) {
		this.img01 = img01;
	}
	public String getImg01Descript() {
		return img01Descript;
	}
	public void setImg01Descript(String img01Descript) {
		this.img01Descript = img01Descript;
	}
	public byte[] getImg02() {
		return img02;
	}
	public void setImg02(byte[] img02) {
		this.img02 = img02;
	}
	public String getImg02Descript() {
		return img02Descript;
	}
	public void setImg02Descript(String img02Descript) {
		this.img02Descript = img02Descript;
	}
	public byte[] getImg03() {
		return img03;
	}
	public void setImg03(byte[] img03) {
		this.img03 = img03;
	}
	public String getImg03Descript() {
		return img03Descript;
	}
	public void setImg03Descript(String img03Descript) {
		this.img03Descript = img03Descript;
	}
	
	@Transient
	private String showImg01;
	@Transient
	private String showImg02;
	@Transient
	private String showImg03;
	

	public void setShowImg01(String itm01) {
	this.showImg01 = itm01;
	}
	public String getShowImg01() {
	return showImg01;
	}
	public String showImg01(){
	    String encoded = "";
	    
	    if(img01 != null && img01.length>0){
	    	encoded = Base64.getEncoder().encodeToString(img01);
	    }
	    return encoded;
	}
	
	public void setShowImg02(String itm02) {
		this.showImg02 = itm02;
		}
		public String getShowItem02() {
		return showImg02;
		}
		public String showImg02(){
		    String encoded = "";
		    
		    if(img02 != null && img02.length>0){
		            encoded = Base64.getEncoder().encodeToString(img02);
		      }
		     return encoded;
		}
		
		public void setShowImg03(String itm03) {
			this.showImg03 = itm03;
			}
			public String getShowImg03() {
			return showImg03;
			}
			public String showImg03(){
			    String encoded = "";
			    
			    if(img01 != null && img01.length>0){
			            encoded = Base64.getEncoder().encodeToString(img03);
			      }
			     return encoded;
			}
	
}
