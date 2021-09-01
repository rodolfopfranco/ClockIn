package com.dio.clockIn.controller;

import com.dio.clockIn.model.DateType;
import com.dio.clockIn.service.DateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dateType")
public class DateTypeController {
    @Autowired
    DateTypeService dateTypeService;

    @PostMapping
    public DateType createDateType(@RequestBody DateType dateType){
        return dateTypeService.saveDateType(dateType);
    }

    @GetMapping("/list")
    public List<DateType> getDateType(){
        return dateTypeService.listDateType();
    }

    @GetMapping("/{idDateType}")
    public ResponseEntity<DateType> getDateTypeById(@PathVariable("idDateType") long id) throws Exception {
        return ResponseEntity.ok(
                dateTypeService.getDateTypeById(id).orElseThrow(()->new Exception("DateType not found"))
        );
    }

    @PutMapping
    public DateType updateDateType(@RequestBody DateType dateType){
        return dateTypeService.updateDateType(dateType);
    }

    @DeleteMapping("/{idDateType}")
    public ResponseEntity deleteDateTypeById(@PathVariable("idDateType") long id) {
        try{
            dateTypeService.deleteDateType(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<DateType>) ResponseEntity.ok();
    }
}
