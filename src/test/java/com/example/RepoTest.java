package com.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Hotel;
import com.example.entity.Room;
import com.example.repo.HotelRepo;
import com.example.repo.RoomRepo;

@SpringBootTest
public class RepoTest {

	
	
	
	@Test 
	void contextLoads(){
	}	
	
	
	    @Autowired
		HotelRepo repoHotel;
	    
	    @Autowired
	    RoomRepo repoRoom;
	
	
	@Test
	void testHotel(){
		
		
		Hotel hotel = new Hotel("Sunnyhill", "chip drive");
		
		 repoHotel.save(hotel);
			
	}
	
	@Test
	void testAddingRoom() {
		
       Hotel hotel2 = new Hotel("chucky cheese", "chuck road");
		
		List <Room> rooms = new ArrayList<Room>();
		
		
		Room room = new Room(23, "king", 's', 50000);
		
		room.setHotel(hotel2);
		
		rooms.add(room);
		
		
		hotel2.setRooms(rooms);
		
		repoHotel.save(hotel2);
				
	}
	
	@Test
	void testUpdateReservationOnRoomRepo() {
		
		Hotel hotel = new Hotel("pooop", "ppoop");
		Room room = new Room(6, "king", 's', 5.12);
		room.setHotel(hotel);
		hotel.addRoom(room);
		
		repoHotel.save(hotel);
		
		repoRoom.addReservation("Claire", 's', "king");		
		
	}
	
	
}
