package com.dio.clockIn.controller;

import com.dio.clockIn.model.BankedHours;
import com.dio.clockIn.service.BankedHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bankedHours")
public class BankedHoursController {
    @Autowired
    BankedHoursService bankedHoursService;

    @PostMapping
    public BankedHours createBankedHours(@RequestBody BankedHours bankedHours){
        return bankedHoursService.saveBankedHours(bankedHours);
    }

    @GetMapping("/list")
    public List<BankedHours> getBankedHours(){
        return bankedHoursService.listBankedHours();
    }

    @GetMapping("/{idBankedHours}")
    public ResponseEntity<BankedHours> getBankedHoursById(@PathVariable("idBankedHours") long id) throws Exception {
        return ResponseEntity.ok(
                bankedHoursService.getBankedHoursById(id).orElseThrow(()->new Exception("BankedHours not found"))
        );
    }

    @PutMapping
    public BankedHours updateBankedHours(@RequestBody BankedHours bankedHours){
        return bankedHoursService.updateBankedHours(bankedHours);
    }

    @DeleteMapping("/{idBankedHours}")
    public ResponseEntity deleteBankedHoursById(@PathVariable("idBankedHours") long id) {
        try{
            bankedHoursService.deleteBankedHours(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<BankedHours>) ResponseEntity.ok();
    }
    
}
