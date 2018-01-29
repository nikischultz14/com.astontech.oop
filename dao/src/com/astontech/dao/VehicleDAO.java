package com.astontech.dao;

import com.astontech.bo.Vehicle;

import java.util.List;

public interface VehicleDAO {
    //get methods
    public Vehicle getVehicleById(int vehicleId);
    public List<Vehicle> getVehicleList();

    //execute methods
    public int insertVehicle(Vehicle vehicle);
    public boolean updateVehicle(Vehicle vehicle);
    public boolean deleteVehicle(int vehicleId);
}









