import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactionsContainerComponent } from './reactions-container.component';

describe('ReactionsContainerComponent', () => {
  let component: ReactionsContainerComponent;
  let fixture: ComponentFixture<ReactionsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReactionsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReactionsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
