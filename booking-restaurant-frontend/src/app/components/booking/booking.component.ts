import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from 'src/app/models/booking.model';
import { Restaurant } from 'src/app/models/restaurant.model';
import { PaymentService } from 'src/app/service/payment.service';
import { BookingService } from '../../service/booking.service';
import { InfoDialogComponent } from '../info-dialog/info-dialog.component';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  public bookingForm: FormGroup;
  public restaurant = new Restaurant();
  public booking = new Booking();
  private idRestaurant: number;

  constructor(public dialog: MatDialog,
    private fb: FormBuilder,
    private bookingService: BookingService,
     private paymentService: PaymentService,
    private route: ActivatedRoute,
  private router: Router) { }

  ngOnInit(): void {
    this.idRestaurant = Number(this.route.snapshot.paramMap.get('id'))
    this.getRestaurant();
    this.initForm();
  }

  getRestaurant() {
    this.bookingService.getRestaurant(this.idRestaurant).subscribe((result: any) => {
      this.restaurant = result.data
    })
  }

  initForm() {
    this.bookingForm = this.fb.group({
      date: [new Date(), Validators.required],
      time: ['', Validators.required],
      customers: ['', Validators.required]
    });
  }

  setBooking() {
    this.booking.restaurantId = this.idRestaurant;
    this.booking.turnId = this.bookingForm.get('time')?.value
    this.booking.date = this.bookingForm.get('date')?.value
    this.booking.person = this.bookingForm.get('customers')?.value
  }



  createReservation() {
    this.setBooking()
    this.bookingService.createReservation(this.booking).subscribe((result: any) => {
      console.log(result.data)
      const title = "CÓDIGO DE RESERVA: " + result.data
      const info = "Necesitarás el código para poder acceder al restaurante o cancelar la reserva. Por favor guardalo en un lugar seguro"
      this.openDialog(title, info)
    })
  }

  payBooking(){
    this.setBooking()
    this.bookingService.createReservation(this.booking).subscribe((result: any)=> {
      this.paymentService.setBooked({ ...this.booking, locator: result.data})
      this.router.navigate(['payment'])
    })
  }


  openDialog(title: string, info: string): void {
    const dialogRef = this.dialog.open(InfoDialogComponent, {
      width: '350px',
      data: { title: title, info: info }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}