package com.booking.dtos;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class CreateReservationDto {
    private Long restaurantId;
    private LocalDateTime date;
    private Long person;
    private Long turnId;
}
