import { TestBed } from '@angular/core/testing';

import { GroupMsgService } from './group-msg.service';

describe('GroupMsgService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GroupMsgService = TestBed.get(GroupMsgService);
    expect(service).toBeTruthy();
  });
});
