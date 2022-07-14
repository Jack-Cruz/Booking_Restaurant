import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Review } from 'src/app/model/review';
import { Servicio } from 'src/app/model/Servicio';
import { ControllerService } from 'src/app/services/controller.service';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  public reservaForm: FormGroup;
  public servicio: Servicio = new Servicio();
  private idServicio: number;
  public reviews ?: Review[];

  constructor(
    private servicioService: ServicioService,
    private route:ActivatedRoute,
    private router: Router,
    private controllerService: ControllerService
  ) { }

  

  getServicio(): void{
    this.servicioService.getServicio(this.idServicio).subscribe(
      (result: any) => {
        this.servicio = result.data
      }
    )
  }

  getReviews(): void{
    this.controllerService.getReviews().subscribe(
      (result: any) => {
        console.log('Reviews ', result)
        this.reviews = result.data
        console.log('Reviews  ', this.reviews)
    //    this.reviews.filter(x => x.servicio_id == this.servicio.id)
      }
    )
  }

  createReserva() {
    true;
  }

  ngOnInit(): void {
    this.idServicio = Number(this.route.snapshot.paramMap.get('sid'));
    this.getServicio();
    this.getReviews();
  }
}
