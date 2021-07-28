import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchpetsComponent } from './searchpets.component';

describe('SearchpetsComponent', () => {
  let component: SearchpetsComponent;
  let fixture: ComponentFixture<SearchpetsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchpetsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchpetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
