package com.booking.dtos;

import lombok.Getter;


import java.time.LocalDateTime;


@Getter
public class ReservationDto {
    private String locator;
    private Long person;
    private LocalDateTime date;
    private Long turnId;
    private Long restaurantId;
}
