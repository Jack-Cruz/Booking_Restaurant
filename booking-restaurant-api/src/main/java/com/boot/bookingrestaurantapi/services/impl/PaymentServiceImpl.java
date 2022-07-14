package com.boot.bookingrestaurantapi.services.impl;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.PaymentConfirmRest;
import com.boot.bookingrestaurantapi.jsons.PaymentIntentRest;
import com.boot.bookingrestaurantapi.services.PaymentService;
import com.boot.bookingrestaurantapi.services.ReservationService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Value("${stripe.key.secret}")
    String secretKey;

    @Autowired
    private ReservationService reservationService;

    public enum Currency{
        USD, EUR;
    }

    @Override
    public PaymentIntent paymentIntent(PaymentIntentRest paymentIntentRest) throws StripeException {
        Stripe.apiKey=secretKey;
        Map<String, Object> params=new HashMap<>();
        params.put("currency",Currency.EUR);
        params.put("amount", paymentIntentRest.getPrice());
        params.put("description",paymentIntentRest.getDescription());

        List<Object> paymentMethodTypes =
                new ArrayList<>();
        paymentMethodTypes.add("card");
        params.put("payment_method_types", paymentMethodTypes);

        return PaymentIntent.create(params);
    }

    @Override
    public PaymentIntent paymentConfirm(PaymentConfirmRest paymentConfirmRest) throws StripeException , BookingException {
        Stripe.apiKey=secretKey;
        PaymentIntent paymentIntent=PaymentIntent.retrieve(paymentConfirmRest.getPaymentId());
        Map<String, Object> params=new HashMap<>();
        params.put("payment_method","pm_card_visa");
        paymentIntent.confirm(params);

        reservationService.updateReservation(true,paymentConfirmRest.getLocator());
        return paymentIntent;
    }

    @Override
    public PaymentIntent paymentCancel(String paymentId) throws StripeException {
        Stripe.apiKey=secretKey;
        PaymentIntent paymentIntent=PaymentIntent.retrieve(paymentId);
        paymentIntent.cancel();
        return paymentIntent;
    }
}
