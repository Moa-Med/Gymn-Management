import { TestBed } from '@angular/core/testing';

import { DataFromEndOfficeService } from './data-from-end-office.service';

describe('DataFromEndOfficeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DataFromEndOfficeService = TestBed.get(DataFromEndOfficeService);
    expect(service).toBeTruthy();
  });
});
