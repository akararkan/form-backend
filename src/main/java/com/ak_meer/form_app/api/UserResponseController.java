package com.ak_meer.form_app.api;

import com.ak_meer.form_app.model.UserResponse;
import com.ak_meer.form_app.service.NotificationService;
import com.ak_meer.form_app.service.UserResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responses")
public class UserResponseController {
    @Autowired
    private UserResponseService userResponseService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/submit")
    public UserResponse submitResponse(@RequestBody UserResponse userResponse) {
        UserResponse savedResponse = userResponseService.saveUserResponse(userResponse);
        notificationService.notifyAdminAndUser(savedResponse);
        return savedResponse;
    }
    @GetMapping("/allResponses")
    public List<UserResponse> getAllResponses(){
        return userResponseService.getAllUserResponse();
    }

    @DeleteMapping("/deleteResponse/{id}")
    public void deleteResponseById(@PathVariable Long id){
        userResponseService.deleteById(id);
    }
}