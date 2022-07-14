import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../models/booking.model';
import { PaymentConfirm } from '../models/paymentconfirm.model';
import { PaymentIntent } from '../models/paymentintent.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private booked: Booking;
  private API = "http://localhost:8089/booking-restaurant/v1/payments/"

  constructor(
     private http: HttpClient
  ) { }

  setBooked(booked: Booking) {
    this.booked = booked
  }

  getBooked(){
    return this.booked
  }
  
  buy(payment: PaymentIntent) {
    return this.http.post(this.API + 'paymentIntent', payment)
  }
  
  cancel(id: string) {
    return this.http.post(this.API + 'cancel/' + id, {})
  }
  
  confirm(paymentConfirm: PaymentConfirm) {
    //return this.http.post(this.API + 'confirm/' +paymentConfirm.paymentId, paymentConfirm)
    return this.http.post(this.API + 'confirm/' , paymentConfirm)
  }
}
