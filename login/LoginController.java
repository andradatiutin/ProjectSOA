package com.ubb.login.controller;

import com.ubb.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        System.out.println("login()");
        return new ResponseEntity<>(loginService.getUsers(), HttpStatus.OK);
    }
}
