package com.dio.clockIn.controller;

import com.dio.clockIn.model.Movement;
import com.dio.clockIn.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movement")
public class MovementController {
    @Autowired
    MovementService movementService;

    @PostMapping
    public Movement createMovement(@RequestBody Movement movement){
        return movementService.saveMovement(movement);
    }

    @GetMapping("/list")
    public List<Movement> getMovement(){
        return movementService.listMovement();
    }

    @GetMapping("/{idMovement}")
    public ResponseEntity<Movement> getMovementById(@PathVariable("idMovement") long id) throws Exception {
        return ResponseEntity.ok(
                movementService.getMovementById(id).orElseThrow(()->new Exception("Movement not found"))
        );
    }

    @PutMapping
    public Movement updateMovement(@RequestBody Movement movement){
        return movementService.updateMovement(movement);
    }

    @DeleteMapping("/{idMovement}")
    public ResponseEntity deleteMovementById(@PathVariable("idMovement") long id) {
        try{
            movementService.deleteMovement(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<Movement>) ResponseEntity.ok();
    }
}
