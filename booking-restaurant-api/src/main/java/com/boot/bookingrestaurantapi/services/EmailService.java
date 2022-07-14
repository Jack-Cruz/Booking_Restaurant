package com.boot.bookingrestaurantapi.services;

import com.boot.bookingrestaurantapi.exceptions.BookingException;

public interface EmailService {
    public  String processSendEmail(String receiver, String subject, String templateCode, String currentName) throws BookingException;
}
