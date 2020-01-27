import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FriendsPostsContainerComponent } from './friends-posts-container.component';

describe('FriendsPostsContainerComponent', () => {
  let component: FriendsPostsContainerComponent;
  let fixture: ComponentFixture<FriendsPostsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FriendsPostsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendsPostsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
