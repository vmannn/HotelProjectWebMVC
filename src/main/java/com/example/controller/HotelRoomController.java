package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Room;

import com.example.services.HotelService;

@Controller
public class HotelRoomController {


	
	@Autowired
	HotelService hotelService;
	
	@RequestMapping("/")
	public String homePage() {
		
		return "index";
		
	}
	
	
	@RequestMapping("/list_hotel_rooms")
	public String hotelRooms(Model model) {
		
		ArrayList <Room> rooms = (ArrayList<Room>) hotelService.getAllRooms();
		model.addAttribute("rooms", rooms);
		return "rooms";
				
	}
	

     @RequestMapping("/edit/{id}")
     public ModelAndView updateReservation(@PathVariable(name = "id") int id) {
    	 
    	 ModelAndView m = new ModelAndView("update_reservation");
    	 Room room = hotelService.getRoomById(id);
    	 m.addObject("reservation", room);
    	 return m;
    	 
     }
	
	
	
}
