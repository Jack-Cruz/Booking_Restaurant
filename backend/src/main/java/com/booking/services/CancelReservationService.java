package com.booking.services;

import com.booking.exceptions.BookingException;

public interface CancelReservationService {
    String deleteReservation(String locator) throws BookingException;
}
