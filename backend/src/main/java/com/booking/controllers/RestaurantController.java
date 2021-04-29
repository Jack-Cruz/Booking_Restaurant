package com.booking.controllers;

import com.booking.dtos.CreateRestaurantDto;
import com.booking.dtos.RestaurantDto;
import com.booking.exceptions.BookingException;
import com.booking.responses.BookingResponse;
import com.booking.services.RestaurantService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/booking-restaurant"+"/v1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restaurants/{restaurantId}")
    public BookingResponse<RestaurantDto> getRestaurantById(@PathVariable Long restaurantId)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                restaurantService.getRestaurantById(restaurantId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restaurants")
    public BookingResponse<List<RestaurantDto>> getRestaurants()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                restaurantService.getRestaurants());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/restaurants")
    public BookingResponse<RestaurantDto> createRestaurant(@RequestBody CreateRestaurantDto createRestaurantDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                restaurantService.createRestaurant(createRestaurantDto));
    }

}
