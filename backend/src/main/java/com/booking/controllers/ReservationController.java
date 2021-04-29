package com.booking.controllers;

import com.booking.dtos.CreateReservationDto;
import com.booking.dtos.ReservationDto;
import com.booking.exceptions.BookingException;
import com.booking.responses.BookingResponse;
import com.booking.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/booking-restaurant"+"/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/reservation/{reservationId}")
    public BookingResponse<ReservationDto> getReservationId(@PathVariable Long reservationId) throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK), "OK",
                reservationService.getReservation(reservationId));
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/reservation")
    public BookingResponse<String> createReservation(@RequestBody CreateReservationDto createReservationDto) throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK), "OK",
                reservationService.createReservation(createReservationDto));
    }


}
