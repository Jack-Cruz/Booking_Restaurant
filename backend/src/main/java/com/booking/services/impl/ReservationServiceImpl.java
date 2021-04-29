package com.booking.services.impl;

import com.booking.dtos.CreateReservationDto;
import com.booking.dtos.ReservationDto;
import com.booking.entities.Reservation;
import com.booking.entities.Restaurant;
import com.booking.entities.Turn;
import com.booking.exceptions.BookingException;
import com.booking.exceptions.InternalServerErrorException;
import com.booking.exceptions.NotFoundException;
import com.booking.repositories.ReservationRepository;
import com.booking.repositories.RestaurantRepository;
import com.booking.repositories.TurnRepository;
import com.booking.services.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//http://modelmapper.org/getting-started/
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private TurnRepository turnRepository;

    @Override
    public ReservationDto getReservation(Long reservationId) throws BookingException {
        return modelMapper.map(getReservationEntity(reservationId), ReservationDto.class);
    }

    @Transactional
    @Override
    public String createReservation(CreateReservationDto createReservationDto) throws BookingException {
        Restaurant restaurantId = restaurantRepository.findById(createReservationDto.getRestaurantId())
                .orElseThrow(() -> new NotFoundException("NOT-401-1", "RESTAURANT_NOT_FOUND"));

        Turn turn = turnRepository.findById(createReservationDto.getTurnId())
                .orElseThrow(() -> new NotFoundException("NOT-401-1", "TURN_NOT_FOUND"));

        if (reservationRepository.findByTurnAndRestaurantId(turn.getName(), restaurantId.getId()).isPresent()) {
            throw new NotFoundException("RESERVATION_EXIST", "RESERVATION_EXIST");
        }
        // Name Restaurant + Turn Name
        String locator = geneteLocator(restaurantId, createReservationDto);

        Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationDto.getPerson());
        reservation.setDate(createReservationDto.getDate());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turn.getName());

        try {
            reservationRepository.save(reservation);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_ERROR", "INTERNAL_ERROR");
        }

        return locator;
    }

    private String geneteLocator(Restaurant restaurantId, CreateReservationDto createReservationDto)
            throws BookingException {
        return restaurantId.getName()+createReservationDto.getTurnId();
    }

    private Reservation getReservationEntity(Long reservationId) throws BookingException {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NotFoundException("NOT-401-1", "RESERVATION_NOT_FOUND"));
    }
}
