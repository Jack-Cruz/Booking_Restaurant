package com.booking.services;


import com.booking.dtos.CreateReservationDto;
import com.booking.dtos.ReservationDto;
import com.booking.exceptions.BookingException;

public interface ReservationService {
    //User Stories
    ReservationDto getReservation(Long reservationId) throws BookingException;
    String createReservation(CreateReservationDto createReservationDto) throws BookingException;
}
