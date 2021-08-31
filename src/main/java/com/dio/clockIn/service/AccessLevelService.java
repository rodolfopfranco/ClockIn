package com.dio.clockIn.service;

import com.dio.clockIn.model.AccessLevel;
import com.dio.clockIn.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    AccessLevelRepository companyRepository;

    @Autowired
    public AccessLevelService(AccessLevelRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public AccessLevel saveAccessLevel(AccessLevel company){
        return companyRepository.save(company);
    }

    public void deleteAccessLevel(Long id){
        companyRepository.deleteById(id);
    }

    public List<AccessLevel> listAccessLevel(){
        return companyRepository.findAll();
    }

    public Optional<AccessLevel> getAccessLevelById(Long id){
        return companyRepository.findById(id);
    }

    public AccessLevel updateAccessLevel(AccessLevel company){
        return companyRepository.save(company);
    }



}
