package com.ubb.shop.service;

import com.ubb.shop.domain.Shop;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class ShopService {

    private List<Shop> shops=new ArrayList<>(Arrays.asList(new Shop("Shop1","Product1","Address1"),
            new Shop("Shop2","Product1","Address2"),
            new Shop("Shop3","Product2","Address3"),
            new Shop("Shop4","Product3","Address4")));

    public List<Shop> getShops() {
        return shops;
    }

    public List<Shop> getShopsForProduct(String product) {
        List<Shop> shopList = new ArrayList<>();
        for(Shop s:shops){
            if(product.equalsIgnoreCase(s.getProduct())){
                shopList.add(s);
            }
        }

        return shopList;
    }
}
