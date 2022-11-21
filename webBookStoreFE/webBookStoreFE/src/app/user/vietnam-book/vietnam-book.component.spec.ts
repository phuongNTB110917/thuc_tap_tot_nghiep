import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VietnamBookComponent } from './vietnam-book.component';

describe('VietnamBookComponent', () => {
  let component: VietnamBookComponent;
  let fixture: ComponentFixture<VietnamBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VietnamBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VietnamBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
