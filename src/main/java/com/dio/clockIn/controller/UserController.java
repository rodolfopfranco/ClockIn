package com.dio.clockIn.controller;

import com.dio.clockIn.model.User;
import com.dio.clockIn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/list")
    public List<User> getUser(){
        return userService.listUser();
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable("idUser") long id) throws Exception {
        return ResponseEntity.ok(
                userService.getUserById(id).orElseThrow(()->new Exception("User not found"))
        );
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity deleteUserById(@PathVariable("idUser") long id) {
        try{
            userService.deleteUser(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<User>) ResponseEntity.ok();
    }
}
