package com.frontline.paymentservice.controller;

import com.frontline.paymentservice.model.Item;
import com.frontline.paymentservice.model.Payment;
import com.frontline.paymentservice.service.ItemService;
import com.frontline.paymentservice.service.PaymentService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) throws JSONException {
//        double price = itemService.getItemTotalPrice(itemId, quantity);
        Item item = new Item();
        item.setItemID(payment.getItemId());
        item.setQuantity(payment.getQuantity());
        item.setPrice(payment.getPrice());
        itemService.decreaseQuantity(item);
        return paymentService.addPayment(payment);
    }

    @GetMapping(value = "/{paymentId}")
    public Payment getPayment(@PathVariable int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @DeleteMapping(value = "/{paymentId}")
    public Payment deletePayment(@PathVariable int paymentId) {
        return paymentService.deletePayment(paymentId);

    }

    @PutMapping(value = "/{paymentId}")
    public Payment updatePayment(@PathVariable int paymentId, @RequestBody Payment payment) {
        return paymentService.updatePayment(paymentId, payment);
    }

    @GetMapping(value = "/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
