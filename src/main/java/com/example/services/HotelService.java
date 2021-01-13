package com.example.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Hotel;
import com.example.entity.Room;
import com.example.repo.HotelRepo;
import com.example.repo.RoomRepo;


@Service
public class HotelService {

	
	@Autowired
	HotelRepo hotelRepo;
	
	@Autowired
	RoomRepo roomRepo;
	

	
	
	
	
	@Transactional
	public void addHotel(String name, String location) {

		Hotel hotel = new Hotel(name, location);
		
		hotelRepo.save(hotel);
		
		
			
	}
	
	
	@Transactional
	public void addRoom(int roomNumber, String bedType, char smoking, double rate, Hotel hotel){
		
         
		Room room = new Room(roomNumber, bedType, smoking, rate);
		room.setHotel(hotel);
		hotel.addRoom(room);
	
		hotelRepo.save(hotel);
	
		}
		

	@Transactional
	public void addReservation(String name, char smoking, String bedType) {
		
			
		roomRepo.addReservation(name, smoking, bedType);
		
				
	}
	
	@Transactional
	public List <Room> getAllRooms() {
		
		ArrayList<Room> rooms = new ArrayList<Room>(roomRepo.findAll());
		
		return rooms;
		
	}
	
	@Transactional
	public Room getRoomById(int id) {
		
		Optional<Room> room = roomRepo.findById(id);
		
		if(room.isPresent())
			return room.get();
		
		else 
			return null;
		
	}
	

	@Transactional
	public void printReservation() {
		
       
		 List <Hotel> hotel = hotelRepo.findAll();	
		 for(Hotel a : hotel) {
			 
			 a.printReservationList();
		 }
		 
    }
	
}
