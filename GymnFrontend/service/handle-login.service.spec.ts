import { TestBed } from '@angular/core/testing';

import { HandleLoginService } from './handle-login.service';

describe('HandleLoginService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HandleLoginService = TestBed.get(HandleLoginService);
    expect(service).toBeTruthy();
  });
});
