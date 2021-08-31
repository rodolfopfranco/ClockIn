package com.dio.clockIn.controller;

import com.dio.clockIn.model.UserCategory;
import com.dio.clockIn.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userCategory")
public class UserCategoryController {
    @Autowired
    UserCategoryService userCategoryService;

    @PostMapping
    public UserCategory createUserCategory(@RequestBody UserCategory userCategory){
        return userCategoryService.saveUserCategory(userCategory);
    }

    @GetMapping("/list")
    public List<UserCategory> getUserCategoryList(){
        return userCategoryService.getUserCategoryList();
    }

    @GetMapping("/{idUserCategory}")
    public ResponseEntity<UserCategory> getWorkingDayById(@PathVariable("idUserCategory") long id) throws Exception {
        return ResponseEntity.ok(
                userCategoryService.getUserCategoryById(id).orElseThrow(()->new Exception("User Category not found"))
        );
    }

    @PutMapping
    public UserCategory updateUserCategory(@RequestBody UserCategory userCategory){
        return userCategoryService.updateUserCategoryById(userCategory);
    }

    @DeleteMapping("/{idUserCategory}")
    public ResponseEntity deleteUserCategoryById(@PathVariable("idUserCategory") long id) {
        try{
            userCategoryService.deleteUserCategory(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<UserCategory>) ResponseEntity.ok();
    }
}
