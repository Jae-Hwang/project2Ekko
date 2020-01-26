import { TestBed } from '@angular/core/testing';

import { DirMsgService } from './dir-msg.service';

describe('DirMsgService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DirMsgService = TestBed.get(DirMsgService);
    expect(service).toBeTruthy();
  });
});
