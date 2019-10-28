import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SouscriptionTypeComponent } from './souscription-type.component';

describe('SouscriptionTypeComponent', () => {
  let component: SouscriptionTypeComponent;
  let fixture: ComponentFixture<SouscriptionTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SouscriptionTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SouscriptionTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
