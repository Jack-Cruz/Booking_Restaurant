package com.booking.repositories;

import com.booking.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Optional<Reservation> findById(Long id);
    Optional<Reservation> findByLocator(String locator);
    Optional<Reservation> findByLocatorAndTurn(String locator, String turn);

    Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);

    @Modifying
    @Transactional
    Optional<Reservation> deleteByLocator(String locator);


}
