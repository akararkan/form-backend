package com.ak_meer.form_app.service;

import com.ak_meer.form_app.model.UserResponse;
import com.ak_meer.form_app.repo.UserResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResponseService {
    @Autowired
    private UserResponseRepository userResponseRepository;

    public UserResponse saveUserResponse(UserResponse userResponse) {
        return userResponseRepository.save(userResponse);
    }

    public List<UserResponse> getAllUserResponse() {
        return userResponseRepository.findAll();
    }

    public void deleteById(Long id) {
        userResponseRepository.deleteById(id);
    }
}