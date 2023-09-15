package com.org.service;

import com.razorpay.Order;



import org.json.JSONObject;
import com.razorpay.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {


    private RazorpayClient razorpayClient;
    public String payment()
    {
        try {
            JSONObject options = new JSONObject();
            options.put("amount", 1000); // Amount in paise (Indian currency)
            options.put("currency", "INR");
            options.put("receipt", "order_receipt_123");

            Order order = razorpayClient.orders.create(options);
            return "yes cretaed";
        } catch (RazorpayException e) {
            return "failed";
        }

    }
}
