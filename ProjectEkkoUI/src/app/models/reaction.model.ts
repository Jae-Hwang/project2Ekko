import { AppUser } from './user.model';

export class Reaction {

    constructor(
        public id = 0,
        public owner = new AppUser(),
        public type = 0
    ) { }

}
