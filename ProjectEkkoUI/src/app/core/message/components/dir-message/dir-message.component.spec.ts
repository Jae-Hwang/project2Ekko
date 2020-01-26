import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirMessageComponent } from './dir-message.component';

describe('DirMessageComponent', () => {
  let component: DirMessageComponent;
  let fixture: ComponentFixture<DirMessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirMessageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
