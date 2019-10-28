import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSouscriptionTypeComponent } from './add-souscription-type.component';

describe('AddSouscriptionTypeComponent', () => {
  let component: AddSouscriptionTypeComponent;
  let fixture: ComponentFixture<AddSouscriptionTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddSouscriptionTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSouscriptionTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
