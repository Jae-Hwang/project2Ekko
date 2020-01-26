import { Component, OnInit, Input } from '@angular/core';
import { Reaction } from 'src/app/models/reaction.model';

@Component({
  selector: 'app-reaction',
  templateUrl: './reaction.component.html',
  styleUrls: ['./reaction.component.css']
})
export class ReactionComponent implements OnInit {

  // tslint:disable-next-line: no-input-rename
  @Input('input-reactions')
  reactions: Reaction[];

  reactionMap = new Map<number, number>();

  uniqueList: number[];



  constructor() { }

  ngOnInit() {
    this.resolveReactions();
  }

  resolveReactions() {
    this.uniqueList = new Array();
    this.reactions.forEach(reaction => {
      let val = 1;

      if (this.reactionMap.has(reaction.type)) {
        val = this.reactionMap.get(reaction.type) + 1;
      } else {
        this.uniqueList.push(reaction.type);
      }
      this.reactionMap.set(reaction.type, val);
    });

  }

}
