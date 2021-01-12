package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Hotel;
import com.example.repo.HotelRepo;
import com.example.repo.RoomRepo;
import com.example.services.HotelService;

@SpringBootTest
class ServiceTests {

	@Test
	void contextLoads() {
	}
	
	@Mock
	HotelRepo hotelRepo;
	
	@Mock
	RoomRepo roomRepo;
	
	@InjectMocks
	@Autowired
    HotelService hotelService;
	
	
	@Test
	public void testAddHotelService() {
		
		hotelService.addHotel("Atom Beach Hotel", "3423 linwood rd");
		
		
	}
	
	@Test
	public void testAddRoomService() {
		
	    Hotel hotel = new Hotel("Marlago", "232 burger rd");	
	
		hotelService.addRoom(1, "king", 's', 5.12, hotel);
		
	}

	@Test
	public void testAddReservation() {
		
		Hotel hotel = new Hotel("dairy", "milky rd");
		hotelService.addRoom(6, "queen", 's', 5.12, hotel);
		
		roomRepo.addReservation("Charlotte",'s', "queen");
		
		
	}
	
	@Test
	public void printReservationListTest() {
		
	     hotelService.printReservation();
		
	}
	
	

}
