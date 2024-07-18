package com.swino.salut.controller;

import com.swino.salut.dto.BaseResponseDto;
import com.swino.salut.dto.UserLoginDto;
import com.swino.salut.entity.User;
import com.swino.salut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BaseResponseDto registerUser(@RequestBody User user) {
        if (userService.createUser(user)) {

            return new BaseResponseDto("Success");
        } else {
            return new BaseResponseDto("Failed");
        }
    }
    @PostMapping("/login")
    public BaseResponseDto loginUser(@RequestBody UserLoginDto userLoginDto) {

        if (userService.checkUserNameExists(userLoginDto.getMail())) {

            if (userService.verifyUser(userLoginDto.getMail(), userLoginDto.getPassword())) {

                Map<String, Object> data = new HashMap<>();

                data.put("token", userService.generateToken(userLoginDto.getMail(), userLoginDto.getPassword()));

                return new BaseResponseDto("Success", data);

            } else {
                return new BaseResponseDto("Wrong password");
            }

        } else {
            return new BaseResponseDto("User Not Exist");
        }


    }
}
