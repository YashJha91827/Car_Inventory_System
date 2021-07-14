package com.hcl.carInventry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.carInventry.dao.CarInventryDao;
import com.hcl.carInventry.model.CarInventry;

@RestController
@RequestMapping("/api")
public class CarInventryController {

	@Autowired
	CarInventryDao carInventryDaoImpl;

	@GetMapping("/getalldata")
	public ResponseEntity<List<CarInventry>> getData() {
		return ResponseEntity.ok(carInventryDaoImpl.getAllData());
	}

	@PostMapping("/savedata")
	public ResponseEntity<String> saveData(@RequestBody CarInventry carInventry) {
		carInventryDaoImpl.saveData(carInventry);
		return ResponseEntity.ok("Data Saved");
	}

	@PutMapping("/updatedata/{inventryNo}")
	public ResponseEntity<String> updateData(@PathVariable("inventryNo") int inventryNo,
			@RequestBody CarInventry carInventry) {
		carInventryDaoImpl.updateData(inventryNo, carInventry);
		//carInventryDaoImpl.updateData(inventryNo, carInventry);
		return ResponseEntity.ok("Data Update");
	}

	@DeleteMapping("/deletedatabyid/{inventryNo}")
	public ResponseEntity<String> deleteDataById(@PathVariable("inventryNo") int inventryNo) {
		carInventryDaoImpl.deleteDataById(inventryNo);
		return ResponseEntity.ok("Data Delete");
	}
}
