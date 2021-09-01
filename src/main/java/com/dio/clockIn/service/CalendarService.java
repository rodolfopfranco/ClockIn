package com.dio.clockIn.service;

import com.dio.clockIn.model.Calendar;
import com.dio.clockIn.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository){
        this.calendarRepository = calendarRepository;
    }

    public Calendar saveCalendar(Calendar calendar){
        return calendarRepository.save(calendar);
    }

    public void deleteCalendar(Long id){
        calendarRepository.deleteById(id);
    }

    public List<Calendar> listCalendar(){
        return calendarRepository.findAll();
    }

    public Optional<Calendar> getCalendarById(Long id){
        return calendarRepository.findById(id);
    }

    public Calendar updateCalendar(Calendar calendar){
        return calendarRepository.save(calendar);
    }
}
