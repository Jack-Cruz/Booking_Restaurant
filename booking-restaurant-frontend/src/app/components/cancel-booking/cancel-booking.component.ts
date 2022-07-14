import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BookingService } from '../../service/booking.service';
import { InfoDialogComponent } from '../info-dialog/info-dialog.component';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {


  codeReservation: string;

  constructor(private bookingService: BookingService,
    public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  cancelBooking() {
    this.bookingService.cancelReservation(this.codeReservation).subscribe((result: any) => {
      const title = "CANCELAR RESERVA: ";// + result.data
      const info = "Tu reserva se ha cancelado con ÉXITO"
      this.openDialog(title, info)
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
