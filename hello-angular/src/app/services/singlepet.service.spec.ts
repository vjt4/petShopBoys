import { TestBed } from '@angular/core/testing';

import { SinglepetService } from './singlepet.service';

describe('SinglepetService', () => {
  let service: SinglepetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SinglepetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
