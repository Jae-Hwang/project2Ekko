import { Component, OnInit, Input } from '@angular/core';
import { Reaction } from 'src/app/models/reaction.model';

@Component({
  selector: 'app-reactions-container',
  templateUrl: './reactions-container.component.html',
  styleUrls: ['./reactions-container.component.css']
})
export class ReactionsContainerComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('input-reactions')
  reactions: Reaction[];

  reactionMap = new Map<number, number>();

  uniqueList: number[];
  usersReaction: Set<number>;

  constructor() { }

  ngOnInit() {
    this.resolveReactions();
  }

  resolveReactions() {
    this.uniqueList = new Array();
    this.usersReaction = new Set();
    this.reactions.forEach(reaction => {
      let val = 1;

      if (this.reactionMap.has(reaction.type)) {
        val = this.reactionMap.get(reaction.type) + 1;
        // if (reaction.owner === this.user)
      } else {
        this.uniqueList.push(reaction.type);
      }
      this.reactionMap.set(reaction.type, val);
    });
    this.uniqueList.sort();
  }

  clickReaction(entry: number) {
    if (this.usersReaction.has(entry)) {
      this.reactionMap.set(entry, this.reactionMap.get(entry) + (-1));
      this.usersReaction.delete(entry);
    } else {
      this.reactionMap.set(entry, this.reactionMap.get(entry) + 1);
      this.usersReaction.add(entry);
    }
  }

}
