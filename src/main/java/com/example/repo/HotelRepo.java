package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Hotel;


public interface HotelRepo extends JpaRepository <Hotel, Integer>{

}
