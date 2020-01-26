import { GroupChat } from './group-chat.model';

export class GroupChatMessage {

    constructor(
        public id = 0,
        public chatMessge = 0,
        public groupChat: GroupChat[] = []
    ) {}
    
}