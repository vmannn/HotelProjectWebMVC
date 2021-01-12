package com.example.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Room;

public interface RoomRepo extends JpaRepository<Room, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Room r set r.occupantName =:name where r.smoking =:smoking and r.bedType =:bedType")
	void addReservation(@Param("name") String name, @Param("smoking") char smoking, @Param("bedType") String bed_type);
	
	
	
}
