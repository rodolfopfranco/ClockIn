package com.dio.clockIn.service;

import com.dio.clockIn.model.DateType;
import com.dio.clockIn.repository.DateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DateTypeService {

    DateTypeRepository dateTypeRepository;

    @Autowired
    public DateTypeService(DateTypeRepository dateTypeRepository){
        this.dateTypeRepository = dateTypeRepository;
    }

    public DateType saveDateType(DateType dateType){
        return dateTypeRepository.save(dateType);
    }

    public void deleteDateType(Long id){
        dateTypeRepository.deleteById(id);
    }

    public List<DateType> listDateType(){
        return dateTypeRepository.findAll();
    }

    public Optional<DateType> getDateTypeById(Long id){
        return dateTypeRepository.findById(id);
    }

    public DateType updateDateType(DateType dateType){
        return dateTypeRepository.save(dateType);
    }
}
