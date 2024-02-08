package com.ubbcluj.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class GatewayController {

//    @RequestMapping(value="/books",method= RequestMethod.GET)
//    public ResponseEntity<?> getBookByTitle(){
//        System.out.println("Calling getBookByTitle");
//        return new ResponseEntity<>("a", HttpStatus.OK);
//    }
}
