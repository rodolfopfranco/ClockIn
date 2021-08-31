package com.dio.clockIn.controller;

import com.dio.clockIn.model.AccessLevel;
import com.dio.clockIn.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accessLevel")
public class AccessLevelController {
    @Autowired
    AccessLevelService accessLevelService;

    @PostMapping
    public AccessLevel createAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.saveAccessLevel(accessLevel);
    }

    @GetMapping("/list")
    public List<AccessLevel> getAccessLevel(){
        return accessLevelService.listAccessLevel();
    }

    @GetMapping("/{idAccessLevel}")
    public ResponseEntity<AccessLevel> getAccessLevelById(@PathVariable("idAccessLevel") long id) throws Exception {
        return ResponseEntity.ok(
                accessLevelService.getAccessLevelById(id).orElseThrow(()->new Exception("AccessLevel not found"))
        );
    }

    @PutMapping
    public AccessLevel updateAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.updateAccessLevel(accessLevel);
    }

    @DeleteMapping("/{idAccessLevel}")
    public ResponseEntity deleteAccessLevelById(@PathVariable("idAccessLevel") long id) {
        try{
            accessLevelService.deleteAccessLevel(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<AccessLevel>) ResponseEntity.ok();
    }
}
