import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Reaction } from 'src/app/models/reaction.model';
import { Subscription } from 'rxjs';
import { AppUser } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { ReactionService } from 'src/app/services/reaction.service';
import { trigger, transition, style, animate } from '@angular/animations';

@Component({
  selector: 'app-reactions-container',
  templateUrl: './reactions-container.component.html',
  styleUrls: ['./reactions-container.component.css'],
  animations: [
    trigger('fade', [
      transition('void => *', [
        style({ opacity: 0 }),
        animate(500, style({ opacity: 1 }))
      ])
    ])
  ]
})
export class ReactionsContainerComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  // tslint:disable-next-line: no-input-rename
  @Input('input-reactions')
  reactions: Reaction[];

  // tslint:disable-next-line: no-input-rename
  @Input('input-type')
  type: string;

  // tslint:disable-next-line: no-input-rename
  @Input('input-id')
  id: number;

  reactionMap = new Map<number, number>();

  uniqueList: number[];
  usersReaction: Set<number>;

  constructor(private authService: AuthService, private reactionService: ReactionService) { }

  resolveReactions() {
    this.uniqueList = new Array();
    this.usersReaction = new Set();
    this.reactions.forEach(reaction => {

      let val = 1;

      if (this.reactionMap.has(reaction.type)) {
        val = this.reactionMap.get(reaction.type) + 1;
      } else {
        if (reaction.owner.id === this.currentUser.id) {
          this.usersReaction.add(reaction.type);
        }
        this.uniqueList.push(reaction.type);
      }
      this.reactionMap.set(reaction.type, val);
    });
    this.uniqueList.sort();
  }

  clickReaction(entry: number) {
    const count = this.reactionMap.get(entry);
    if (this.usersReaction.has(entry)) {
      if (count === 1) {
        this.reactionMap.delete(entry);
        this.uniqueList = this.uniqueList.filter(ele => ele !== entry);
      } else {
        this.reactionMap.set(entry, count - 1);
      }
      this.usersReaction.delete(entry);
      this.reactionService.delete(this.type, this.currentUser.id, this.id);
    } else {
      this.reactionMap.set(entry, count + 1);
      this.usersReaction.add(entry);
      this.reactionService.save(this.type, this.currentUser.id, this.id, entry);
    }

    console.log(`Type: ${this.type}, id: ${this.id}, reaction: ${entry}`);
  }

  addReaction(entry: number) {
    if (this.reactionMap.has(entry)) {
      this.reactionMap.set(entry, this.reactionMap.get(entry) + 1);
    } else {
      this.reactionMap.set(entry, 1);
      this.uniqueList.push(entry);
      this.uniqueList.sort();
    }
    this.usersReaction.add(entry);

    this.reactionService.save(this.type, this.currentUser.id, this.id, entry);
    console.log(`Type: ${this.type}, id: ${this.id}, reaction: ${entry}`);
  }

  userOwned(entry: number) {
    if (this.usersReaction.has(entry)) {
      return 'btn btn-dark reactionbutton';
    } else {
      return 'btn btn-secondary reactionbutton';
    }
  }

  userNotOwned(entry: number) {
    if (this.usersReaction.has(entry)) {
      return false;
    } else {
      return true;
    }
  }

  ngOnInit() {
    this.currentUserSubscription = this.authService.$currentUser.subscribe(user => {
      this.currentUser = user;
    });

    this.resolveReactions();
  }

  ngOnDestroy() {
    if (this.currentUserSubscription !== undefined) {
      this.currentUserSubscription.unsubscribe();
    }
  }

}
