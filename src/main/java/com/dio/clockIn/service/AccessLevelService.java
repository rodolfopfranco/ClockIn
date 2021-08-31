package com.dio.clockIn.service;

import com.dio.clockIn.model.AccessLevel;
import com.dio.clockIn.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    AccessLevelRepository accessLevelRepository;

    @Autowired
    public AccessLevelService(AccessLevelRepository accessLevelRepository){
        this.accessLevelRepository = accessLevelRepository;
    }

    public AccessLevel saveAccessLevel(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }

    public void deleteAccessLevel(Long id){
        accessLevelRepository.deleteById(id);
    }

    public List<AccessLevel> listAccessLevel(){
        return accessLevelRepository.findAll();
    }

    public Optional<AccessLevel> getAccessLevelById(Long id){
        return accessLevelRepository.findById(id);
    }

    public AccessLevel updateAccessLevel(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }



}
