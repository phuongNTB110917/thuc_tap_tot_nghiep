import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsBookComponent } from './news-book.component';

describe('NewsBookComponent', () => {
  let component: NewsBookComponent;
  let fixture: ComponentFixture<NewsBookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewsBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
