package com.ubb.prod.controller;

import com.ubb.prod.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ProdController {

    @Autowired
    ProdService prodService;

    @RequestMapping(value="/prod/{name}",method= RequestMethod.GET)
    public ResponseEntity<?> getProductByName(@PathVariable("name") String name) {
        System.out.println("getProductByName(" + name + ")");
        return new ResponseEntity<>(prodService.geProductByName(name), HttpStatus.OK);
    }

    @RequestMapping(value="/prods",method= RequestMethod.GET)
    public ResponseEntity<?> getProducts(){
        System.out.println("getProducts");
        return new ResponseEntity<>(prodService.getProducts(),HttpStatus.OK);
    }

    @RequestMapping(value="/buy/{name}",method= RequestMethod.POST)
    public ResponseEntity<?> buyProduct(@PathVariable("name")String name) {
        System.out.println("buyProduct(" + name + ")");
        prodService.buyProduct(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
