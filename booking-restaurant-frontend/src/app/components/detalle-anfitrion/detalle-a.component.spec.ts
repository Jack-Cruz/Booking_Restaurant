import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleAComponent } from './detalle-a.component';

describe('DetalleAComponent', () => {
  let component: DetalleAComponent;
  let fixture: ComponentFixture<DetalleAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleAComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
