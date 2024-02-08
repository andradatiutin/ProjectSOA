package com.ubb.shop.controller;

import com.ubb.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value="/shop/{product}",method= RequestMethod.GET)
    public ResponseEntity<?> getShopsByProduct(@PathVariable("product") String product) {
        System.out.println("getShopsByProduct(" + product +")");
        return new ResponseEntity<>(shopService.getShopsForProduct(product), HttpStatus.OK);
    }
}
