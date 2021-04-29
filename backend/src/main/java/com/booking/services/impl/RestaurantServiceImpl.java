package com.booking.services.impl;

import com.booking.dtos.CreateRestaurantDto;
import com.booking.dtos.RestaurantDto;
import com.booking.entities.Restaurant;
import com.booking.exceptions.BookingException;
import com.booking.exceptions.InternalServerErrorException;
import com.booking.exceptions.NotFoundException;
import com.booking.repositories.RestaurantRepository;
import com.booking.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRespository;

    private static final ModelMapper modelMapper=new ModelMapper();

    @Override
    public RestaurantDto getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantDto.class);
    }

    @Override
    public List<RestaurantDto> getRestaurants() throws BookingException {
        List<Restaurant> restaurantsEntity=restaurantRespository.findAll();
        return restaurantsEntity.stream().map(restaurant->modelMapper.map(restaurant,RestaurantDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public RestaurantDto createRestaurant(CreateRestaurantDto createRestaurantDto) throws BookingException {
        Restaurant restaurant=new Restaurant();
        restaurant.setName(createRestaurantDto.getName());
        restaurant.setAddress(createRestaurantDto.getAddress());
        restaurant.setDescription(createRestaurantDto.getDescription());
        restaurant.setImage(createRestaurantDto.getImage());

        try {
            restaurant=restaurantRespository.save(restaurant);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getRestaurantEntity(restaurant.getId()),RestaurantDto.class);
    }

    private Restaurant getRestaurantEntity(Long restaurantId)throws BookingException{
        return restaurantRespository.findById(restaurantId)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
}
