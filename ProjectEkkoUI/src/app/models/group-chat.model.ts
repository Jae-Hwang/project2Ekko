import { AppUser } from './user.model';
import { GroupChatMessage } from './group-chat-message.model';

export class GroupChat {

    constructor(
       public id = 0,
       public chatName = '',
       public groupChatMessages: GroupChatMessage[] = [],
       public userList: AppUser[] = []
    ) {}

}
