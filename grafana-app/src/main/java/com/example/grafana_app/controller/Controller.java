package com.example.grafana_app.controller;


import com.example.grafana_app.dto.UserDto;
import com.example.grafana_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    void sendUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("get-user/{userId}")
    ResponseEntity<UserDto> getUserId(@PathVariable long userId) {
        UserDto userDto = userService.getUser(userId);
        return new ResponseEntity<>(userDto ,HttpStatus.OK);
    }
}
