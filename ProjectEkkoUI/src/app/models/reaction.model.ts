import { AppUser } from './user.model';
import { Post } from './post.model';

export class Reaction {

    constructor(
        public id = 0,
        public owner = new AppUser(),
        public type = 0,
        public parentPost = new Post(),
        public parentComment = new Comment()
    ) { }

}
