package com.booking.services;

import com.booking.dtos.CreateRestaurantDto;
import com.booking.dtos.RestaurantDto;
import com.booking.exceptions.BookingException;

import java.util.List;

public interface RestaurantService {
    RestaurantDto getRestaurantById(Long restaurantId) throws BookingException;
    List<RestaurantDto> getRestaurants()throws BookingException;;
    RestaurantDto createRestaurant(CreateRestaurantDto createRestaurantDto)throws  BookingException;
}
