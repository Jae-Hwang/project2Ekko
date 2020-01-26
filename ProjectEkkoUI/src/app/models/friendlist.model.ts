import { AppUser } from './user.model';

export class Friendlist {

    constructor(
        public owner = 0,
        public users: AppUser[] = [],
    ) { }

}