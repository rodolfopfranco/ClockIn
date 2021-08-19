package com.dio.clockIn.service;

import com.dio.clockIn.model.WorkingDay;
import com.dio.clockIn.repository.WorkingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingDayService {

    WorkingDayRepository workingDayRepository;

    @Autowired
    public WorkingDayService(WorkingDayRepository workingDayRepository){
        this.workingDayRepository = workingDayRepository;
    }

    public WorkingDay saveWorkingDay(WorkingDay workingDay){
        return workingDayRepository.save(workingDay);
    }

    public void deleteWorkingDay(Long id) throws Exception {
        workingDayRepository.deleteById(id);
    }

    public List<WorkingDay> getWorkingDayList(){
        return workingDayRepository.findAll();
    }

    public Optional<WorkingDay> getWorkingDayById(Long idWorkingDay){
        return workingDayRepository.findById(idWorkingDay);
    }

    public WorkingDay updateWorkingDayById(WorkingDay workingDay){
        return workingDayRepository.save(workingDay);
    }

}
