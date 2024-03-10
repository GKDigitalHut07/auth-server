package com.tutorial.authorizationserver.controller;

import com.tutorial.authorizationserver.dto.CreateAppUserDto;
import com.tutorial.authorizationserver.dto.MessageDto;
import com.tutorial.authorizationserver.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@RequestBody CreateAppUserDto dto){
    	if(dto.password().equals(dto.confirmPassword()))
    		return new ResponseEntity<>(new MessageDto("password and confirm password not matches"),HttpStatus.BAD_REQUEST);
    	appUserService.createUser(dto);
        return new ResponseEntity<>(new MessageDto("success"),HttpStatus.OK);
    }
    
}
