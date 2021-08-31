package com.dio.clockIn.controller;

import com.dio.clockIn.model.Location;
import com.dio.clockIn.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationService.saveLocation(location);
    }

    @GetMapping("/list")
    public List<Location> getLocation(){
        return locationService.listLocation();
    }

    @GetMapping("/{idLocation}")
    public ResponseEntity<Location> getLocationById(@PathVariable("idLocation") long id) throws Exception {
        return ResponseEntity.ok(
                locationService.getLocationById(id).orElseThrow(()->new Exception("Location not found"))
        );
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/{idLocation}")
    public ResponseEntity deleteLocationById(@PathVariable("idLocation") long id) {
        try{
            locationService.deleteLocation(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<Location>) ResponseEntity.ok();
    }
}
