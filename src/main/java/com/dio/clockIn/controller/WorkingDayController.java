package com.dio.clockIn.controller;

import com.dio.clockIn.model.WorkingDay;
import com.dio.clockIn.service.WorkingDayService;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workingDay")
public class WorkingDayController {

    @Autowired
    WorkingDayService workingDayService;

    @PostMapping
    public WorkingDay createWorkingDay(@RequestBody WorkingDay workingDay){
        return workingDayService.saveWorkingDay(workingDay);
    }

    @GetMapping
    public List<WorkingDay> getWorkingDayList(){
        return workingDayService.getWorkingDayList();
    }

    @GetMapping("/{idWorkingDay}")
    public ResponseEntity<WorkingDay> getWorkingDayById(@PathVariable("idWorkingDay") long id) throws Exception {
        return ResponseEntity.ok(
                workingDayService.getWorkingDayById(id).orElseThrow(()->new Exception("Working Day not found"))
        );
    }

}
