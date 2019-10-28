import { TestBed } from '@angular/core/testing';

import { HandleSubscriptionTypeService } from './handle-subscription-type.service';

describe('HandleSubscriptionTypeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HandleSubscriptionTypeService = TestBed.get(HandleSubscriptionTypeService);
    expect(service).toBeTruthy();
  });
});
