import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../models/booking.model';



@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private API = 'http://localhost:8089/booking-restaurant/v1/';
  
  constructor(private http: HttpClient) { }

  getAllRestaurants() {
    return this.http.get(this.API + 'restaurants')
  }
  getRestaurant(id: number) {
    return this.http.get(this.API + 'restaurant' + '/' + id)
  }
  createReservation(booking: Booking) {
    return this.http.post(this.API + 'reservation', booking)
  }
  cancelReservation(reservationCode: string) {
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    return this.http.delete(this.API + '?locator=' + reservationCode, options)
  }

}
