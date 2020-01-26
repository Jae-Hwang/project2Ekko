import { AppUser } from './user.model';
import { Reaction } from './reaction.model';

export class Post {

    constructor(
        public id = 0,
        public content = '',
        public user = new AppUser(),
        public comments: Comment[] = [],
        public reactions: Reaction[] = [],
        public upserted: Date = new Date()
    ) { }

}
