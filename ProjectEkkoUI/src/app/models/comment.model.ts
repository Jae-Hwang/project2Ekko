import { AppUser } from './user.model';
import { Post } from './post.model';
import { Reaction } from './reaction.model';

export class Comment {

    constructor(
        public id = 0,
        public content = '',
        public owner = new AppUser(),
        public parent = new Post(),
        public reactions: Reaction[] = [],
        public upserted: Date = new Date()
    ) { }

}
