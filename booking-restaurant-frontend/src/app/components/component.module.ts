import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { MaterialModule } from '../material/material.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BookingComponent } from './booking/booking.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InfoDialogComponent } from './info-dialog/info-dialog.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { PaymentComponent } from './payment/payment.component';
import { NgxStripeModule} from 'ngx-stripe'
@NgModule({
  declarations: [
    LoginComponent,
    DashboardComponent,
    NavbarComponent,
    BookingComponent,
    InfoDialogComponent,
    CancelBookingComponent,
    PaymentComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    NgxStripeModule.forRoot('pk_test_51Ix2oaAfbfzmGRwRHQnJLshYLzZo2RcLiM84U4g823jlPeOJ1fvrt9T0winWXnbX68lntR7WYFeHg9Mb5YNB5fim004d1uxDUx')
  ],
  exports: [
    LoginComponent,
    MaterialModule,
    NavbarComponent,
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class ComponentModule { }
