package com.boot.bookingrestaurantapi.exceptions;

import java.util.Arrays;

import com.boot.bookingrestaurantapi.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends BookingException{


    private static final long serialVersionUID = 1L;

    public InternalServerErrorException(String code, String message) {
        super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(),message);
    }

    public InternalServerErrorException(String code, String message, ErrorDto data) {
        super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(),message, Arrays.asList(data));
    }

}
