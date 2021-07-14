package com.hcl.carInventry.dao;

import java.util.List;

import com.hcl.carInventry.model.CarInventry;

public interface CarInventryDao {

	public List<CarInventry> getAllData();

	public void saveData(CarInventry carInventry);

	public void updateData(int inventryNo, CarInventry carInventry);

	public void deleteDataById(int inventryNo);

}