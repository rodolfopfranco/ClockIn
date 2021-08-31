package com.dio.clockIn.service;

import com.dio.clockIn.model.UserCategory;
import com.dio.clockIn.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    UserCategoryRepository userCategoryRepository;

    @Autowired
    public UserCategoryService(UserCategoryRepository userCategoryRepository){
        this.userCategoryRepository = userCategoryRepository;
    }

    public UserCategory saveUserCategory(UserCategory userCategory){
        return userCategoryRepository.save(userCategory);
    }

    public void deleteUserCategory(Long id) {
        userCategoryRepository.deleteById(id);
    }

    public List<UserCategory> getUserCategoryList(){
        return userCategoryRepository.findAll();
    }

    public Optional<UserCategory> getUserCategoryById(Long idUserCategory){
        return userCategoryRepository.findById(idUserCategory);
    }

    public UserCategory updateUserCategoryById(UserCategory userCategory){
        return userCategoryRepository.save(userCategory);
    }
}
