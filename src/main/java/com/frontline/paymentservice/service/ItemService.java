package com.frontline.paymentservice.service;

import com.frontline.paymentservice.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    public List<Item> getItems(List<String> ids) {
        //TODO: Implement get items by calling Catalog API
        return null;
    }

    public double getItemTotalPrice(String itemId, int quantity) {
        //TODO: Implement a function to calculate the total price
//        double priceOfOneItem;
//        double totalrice = priceOfOneItem * quantity;
        return 0;
    }
}
