package com.dio.clockIn.controller;

import com.dio.clockIn.model.Event;
import com.dio.clockIn.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @GetMapping("/list")
    public List<Event> getEvent(){
        return eventService.listEvent();
    }

    @GetMapping("/{idEvent}")
    public ResponseEntity<Event> getEventById(@PathVariable("idEvent") long id) throws Exception {
        return ResponseEntity.ok(
                eventService.getEventById(id).orElseThrow(()->new Exception("Event not found"))
        );
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{idEvent}")
    public ResponseEntity deleteEventById(@PathVariable("idEvent") long id) {
        try{
            eventService.deleteEvent(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<Event>) ResponseEntity.ok();
    }
}
