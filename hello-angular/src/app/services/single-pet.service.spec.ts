import { TestBed } from '@angular/core/testing';

import { SinglePetService } from './single-pet.service';

describe('SinglePetService', () => {
  let service: SinglePetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SinglePetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
