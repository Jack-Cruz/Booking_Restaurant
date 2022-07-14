import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../../models/restaurant.model';
import { BookingService } from '../../service/booking.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public restaurants: Restaurant[];

  constructor(private bookingService: BookingService) { }

  ngOnInit(): void {
    this.bookingService.getAllRestaurants().subscribe((result: any) => {
      console.log(result.data);
      this.restaurants = result.data;
    })
  }

}
