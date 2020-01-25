import { AppUser } from './user.model';
import { Reaction } from './reaction.model';
import { Comment } from './comment.model';

export class Post {

    constructor(
        public id = 0,
        public content = '',
        public owner = new AppUser(),
        public comments: Comment[] = [],
        public reactions: Reaction[] = [],
        public upserted: Date = new Date()
    ) { }

}
