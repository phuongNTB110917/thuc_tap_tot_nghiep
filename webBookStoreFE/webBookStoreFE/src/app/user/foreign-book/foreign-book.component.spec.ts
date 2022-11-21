import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForeignBookComponent } from './foreign-book.component';

describe('ForeignBookComponent', () => {
  let component: ForeignBookComponent;
  let fixture: ComponentFixture<ForeignBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForeignBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForeignBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
