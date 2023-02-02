import { TestBed } from '@angular/core/testing';

import { ChequerasService } from './chequeras.service';

describe('ChequerasService', () => {
  let service: ChequerasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChequerasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
