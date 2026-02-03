import { TestBed } from '@angular/core/testing';

import { WallmartService } from './wallmart-service';

describe('WallmartService', () => {
  let service: WallmartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WallmartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
