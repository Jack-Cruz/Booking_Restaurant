package com.boot.bookingrestaurantapi.services;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;

import java.util.List;


public interface RestaurantService {

    RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

    public List<RestaurantRest> getRestaurants() throws BookingException;

}
