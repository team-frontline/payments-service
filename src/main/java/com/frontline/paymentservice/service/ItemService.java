package com.frontline.paymentservice.service;

import com.frontline.paymentservice.model.Item;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {
    public void decreaseQuantity(Item itemToUpdate) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject itemObject = new JSONObject();
        itemObject.put("quantity", itemToUpdate.getQuantity());
//        System.out.println(itemObject.toString());

        HttpEntity<String> request = new HttpEntity<String>(itemObject.toString(), headers);

        restTemplate.put("http://localhost:8081/api/item/reduce_quantity/" + itemToUpdate.getItemID(),
                request, Item.class);
    }
}
