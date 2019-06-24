package com.frontline.paymentservice.controller;

import com.frontline.paymentservice.model.Item;
import com.frontline.paymentservice.model.Payment;
import com.frontline.paymentservice.service.ItemService;
import com.frontline.paymentservice.service.PaymentService;
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
    public Payment create(@RequestBody Payment payment) {
        /*TODO:
         * Check price is correct. For that, We have to use itemServices.
         * Call the Item Service API to get the values and calculate
         */
//        double price = itemService.getItemTotalPrice(itemId, quantity);
        return paymentService.addPayment(payment);
    }

    @GetMapping(value = "/items-by-customerid/{customerId}")
    public List<Item> getItemsByCustomerId(@PathVariable String customerId) {
        List<String> itemIds = paymentService.getItemIdsByUserId(customerId);
        List<Item> items = itemService.getItems(itemIds);
        return items;
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

    @GetMapping(value = "/get-by-cutsomerid/{customerId}")
    public List<Payment> getPaymentsByCustomerId(@PathVariable String customerId) {
        return paymentService.getByCustomerId(customerId);
    }
}
