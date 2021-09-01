package com.dio.clockIn.service;


import com.dio.clockIn.model.Location;
import com.dio.clockIn.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id){
        locationRepository.deleteById(id);
    }

    public List<Location> listLocation(){
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long id){
        return locationRepository.findById(id);
    }

    public Location updateLocation(Location location){
        return locationRepository.save(location);
    }
}
