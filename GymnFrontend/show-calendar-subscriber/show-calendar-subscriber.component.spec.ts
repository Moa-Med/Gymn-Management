import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCalendarSubscriberComponent } from './show-calendar-subscriber.component';

describe('ShowCalendarSubscriberComponent', () => {
  let component: ShowCalendarSubscriberComponent;
  let fixture: ComponentFixture<ShowCalendarSubscriberComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowCalendarSubscriberComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCalendarSubscriberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
