package com.example.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	private static final int NOT_FOUND = -1;
	private String name;
	private String location;
	private int occupationCount;
	
	@OneToMany(mappedBy= "hotel", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List <Room> rooms;
	
	private int numOfRooms;
	
	
	
	public Hotel() {
		
		rooms = new ArrayList <Room>();
		name = null;
		location = null;
		occupationCount = 0;
			
		
	}
	
	public Hotel(String name, String location) {
		
		numOfRooms = 0;
	
		this.name = name;
		this.location = location;
		rooms = new ArrayList<Room>();
		
	}
	
	public void addRoom(Room room){
		
		
		rooms.add(room);
		
		numOfRooms += 1;
		
	   
	}
	
	
	public boolean isFull() {
		
		if(occupationCount >= 10)
				return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		
		if(occupationCount <= 0) 	
			return true;
		
		else
			return false;
				
	}
	
	public void addReservation(String name, char smoking, String bedType) {
		StringBuilder sb = new StringBuilder();
		for(Room a: rooms){
			
			if(a.isOccupied())
				continue;
			
			if(smoking == a.getSmoking()){
				
				if(bedType.equals(a.getBedType())) {
					a.setOccupantName(name);
					a.setOccupied(true);
					System.out.println("Reservation for " + name + " Successfully created!");
					occupationCount += 1;
					return;	
				}
			}		
		}
			
		System.out.println("Cannot make a reservation for " + name + " :(" );	
		
		}	
	

	private int findName(StringBuilder name) {
		
		for(int i = 0; i < rooms.size(); ++i) {
			
			if(rooms.get(i).getOccupantName().toString().equals(name.toString())) {
				
				return i;
				
			}	
		}
		
		return NOT_FOUND;
	}
	
    public void cancelReservation(String name) {
    
    	StringBuilder sb = new StringBuilder();
    	int i = findName(sb.append(name));
    	sb.replace(0, sb.length(), "Not Occupied");
    	
    	try {
    	rooms.get(i).setOccupied(false);
    	rooms.get(i).setOccupantName(name);
    	occupationCount -= 1;
    	}
    	catch(IndexOutOfBoundsException e) {
    		
    		System.out.println("No reservation was made for " + name + " so nothing to cancel...");
    		
    	}
    	
    }
    
    public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public int findReservation(String named) {
    	
    	int i = 0;
    	for(Room r: rooms) {
    		
    		if(r.getOccupantName().toString().equals(named)) {
    			return i;		
    		}
    		++i;
    	}  	
    	return NOT_FOUND;
    }
    
    public void printReservationList() {
    	
    	boolean count = false;
    	
    	for(Room r: rooms) {
    		
    		if(r.isOccupied()) {
    			
    			System.out.println("Room number: " + r.getRoomNum());
    			System.out.println("Occupant name: " + r.getOccupantName());
    			System.out.println("Smoking room: " + r.getSmoking());
    			System.out.println("Bed type: " + r.getBedType());
    			System.out.println("Rate: " + r.getRate() + "\n");
    		    count = true;
    		}	
    	}	
    	
    	if(count == false) {
    		
    		System.out.println("No resevations!! :( add a reservation to begin");
    		
    	}
    }
	
    public double getDailySales() {
    	
    	
    	 double total = 0;
         for(Room r: rooms) {
        	 
        	 if(r.isOccupied()) {
        		 total += r.getRate();    
        	 }
         }
         
         return total;
    }
    
    
    public double occupancyPercentage() {
    	
    	
        return (double) occupationCount/rooms.size();
 	    
     
    }
    
    
    
    @Override
    public String toString() {
    	
    	return "Hotel name: " + name + "\n"
    	+ "Location: " + location + "\n"
    	+ "Number of rooms: " + numOfRooms + "\n"
    	+ "Number of occupied rooms: " + occupationCount + "\n\n"
    	
    	+"Room details are:\n\n" + rooms;
    		
    	
    }

	public void setNameAndLocation(String name, String location) {
		
		this.name = name;
		this.location = location;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
    }
    
