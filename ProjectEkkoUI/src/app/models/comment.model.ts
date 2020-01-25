import { Reaction } from './reaction.model';
import { AppUser } from './user.model';

export class Comment {

    constructor(
        public id = 0,
        public content = '',
        public owner = new AppUser(),
        public reactions: Reaction[] = [],
        public upserted: Date = new Date()
    ) { }

}
