package com.dio.clockIn.service;

import com.dio.clockIn.model.Movement;
import com.dio.clockIn.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    MovementRepository movementRepository;

    @Autowired
    public MovementService(MovementRepository movementRepository){
        this.movementRepository = movementRepository;
    }

    public Movement saveMovement(Movement movement){
        return movementRepository.save(movement);
    }

    public void deleteMovement(Long id){
        movementRepository.deleteById(id);
    }

    public List<Movement> listMovement(){
        return movementRepository.findAll();
    }

    public Optional<Movement> getMovementById(Long id){
        return movementRepository.findById(id);
    }

    public Movement updateMovement(Movement movement){
        return movementRepository.save(movement);
    }
}
