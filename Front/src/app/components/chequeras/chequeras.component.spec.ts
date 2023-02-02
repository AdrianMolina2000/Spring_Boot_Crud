import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequerasComponent } from './chequeras.component';

describe('ChequerasComponent', () => {
  let component: ChequerasComponent;
  let fixture: ComponentFixture<ChequerasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChequerasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChequerasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
