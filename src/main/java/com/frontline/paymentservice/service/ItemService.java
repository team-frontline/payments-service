package com.frontline.paymentservice.service;

import com.frontline.paymentservice.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    public List<Item> getItems(List<String> ids) {
        //TODO: Implement get items by calling Catalog API
        List<Item> items = new ArrayList<>(4);
        Item item = new Item();
        item.setCustomerId("1");
        item.setId(1);
        item.setItemName("Name");
        item.setItemId("11");
        item.setSoldQuantity("25");
        items.add(item);
        return items;
    }

    public double getItemTotalPrice(String itemId, int quantity) {
        //TODO: Implement a function to calculate the total price
//        double priceOfOneItem;
//        double totalrice = priceOfOneItem * quantity;
        return 0;
    }
}
