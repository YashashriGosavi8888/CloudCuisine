package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseDto;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private UserServiceImpl userService;

	// get all customers
	@GetMapping("/getAllCustomer")
	public ResponseEntity<?> getAllCustomer() {
		return ResponseEntity.ok().body(new ResponseDto<>("Success", userService.getAllCustomer()));
	}

	// get all deliveryBoys
	@GetMapping("/getAllDeliveryBoy")
	public ResponseEntity<?> getAllDeliveryBoy() {
		return ResponseEntity.ok().body(new ResponseDto<>("Success", userService.getAllDeliveryBoy()));
	}

	// get all restaurants 
	@GetMapping("/getAllRestaurant")
	public ResponseEntity<?> getAllRestaurants() {
		return ResponseEntity.ok().body(new ResponseDto<>("Success", userService.getAllRestaurant()));
	}
	
	
	  @GetMapping("/getAllActiveRestaurants") public ResponseEntity<?>
	  getAllActiveRestaurants() { return ResponseEntity.ok().body(new
	  ResponseDto<>("Success", userService.getAllActiveRestaurants())); }
	 
}