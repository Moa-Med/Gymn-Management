import { TestBed } from '@angular/core/testing';

import { CalendarDataService } from './calendar-data.service';

describe('CalendarDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CalendarDataService = TestBed.get(CalendarDataService);
    expect(service).toBeTruthy();
  });
});
