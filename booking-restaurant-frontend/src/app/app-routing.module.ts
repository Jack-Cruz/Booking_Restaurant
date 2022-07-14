

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { BookingComponent } from './components/booking/booking.component';
import { LoginComponent } from './components/login/login.component';
import { CancelBookingComponent } from './components/cancel-booking/cancel-booking.component';
import { PaymentComponent } from './components/payment/payment.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'restaurants', component: DashboardComponent },
  { path: 'booking/:id', component: BookingComponent },
  { path: 'cancel', component: CancelBookingComponent },
   {path: 'payment', component: PaymentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
