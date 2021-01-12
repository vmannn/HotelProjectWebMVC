package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rooms")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomId;
	
	private int roomNum;
	private String bedType;
	private double rate;
	private String occupantName;
	private char smoking;
	private boolean occupied;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName="id")
	private Hotel hotel;
	

	
	public Room(int roomNum, String bedType, char smoking, double rate) {
		
		StringBuilder sb = new StringBuilder();

		this.roomNum = roomNum;
		this.bedType = bedType;
		this.smoking = smoking;
		this.rate = rate;
		occupantName = null;
		
		
	}
	
	
	
	public Room() {
		StringBuilder sb = new StringBuilder();
		roomNum = 0;
		bedType = null;
		rate = 0;
		occupantName = null;
		smoking = '\u0000';
		occupied = false;
		
	}
	

	public boolean isOccupied() {
		
		return this.occupied;
		
	}



	public int getRoomId() {
		return roomId;
	}



	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}



	public int getRoomNum() {
		return roomNum;
	}



	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}



	public String getBedType() {
		return bedType;
	}



	public void setBedType(String bedType) {
		this.bedType = bedType;
	}



	public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}



	public String getOccupantName() {
		return occupantName;
	}



	public void setOccupantName(String occupantName) {
		this.occupantName = occupantName;
	}



	public char getSmoking() {
		return smoking;
	}



	public void setSmoking(char smoking) {
		this.smoking = smoking;
	}



	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}



	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	
	
}