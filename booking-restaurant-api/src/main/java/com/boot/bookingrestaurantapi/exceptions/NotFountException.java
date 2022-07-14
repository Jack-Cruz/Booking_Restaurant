package com.boot.bookingrestaurantapi.exceptions;

import java.util.Arrays;

import com.boot.bookingrestaurantapi.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

public class NotFountException extends BookingException{

    private static final long serialVersionUID = 1L;

    public NotFountException(String code, String message) {
        super(code,HttpStatus.NOT_FOUND.value(),message);
    }

    public NotFountException(String code, String message, ErrorDto data) {
        super(code,HttpStatus.NOT_FOUND.value(),message, Arrays.asList(data));
    }

}
