import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildrenBookComponent } from './children-book.component';

describe('ChildrenBookComponent', () => {
  let component: ChildrenBookComponent;
  let fixture: ComponentFixture<ChildrenBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildrenBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildrenBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
