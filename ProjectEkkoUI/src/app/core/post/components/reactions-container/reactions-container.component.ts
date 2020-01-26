import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Reaction } from 'src/app/models/reaction.model';
import { Subscription } from 'rxjs';
import { AppUser } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-reactions-container',
  templateUrl: './reactions-container.component.html',
  styleUrls: ['./reactions-container.component.css']
})
export class ReactionsContainerComponent implements OnInit, OnDestroy {

  currentUserSubscription: Subscription;
  currentUser: AppUser;

  // tslint:disable-next-line: no-input-rename
  @Input('input-reactions')
  reactions: Reaction[];

  reactionMap = new Map<number, number>();

  uniqueList: number[];
  usersReaction: Set<number>;

  constructor(private authService: AuthService) { }

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
    } else {
      this.reactionMap.set(entry, count + 1);
      this.usersReaction.add(entry);
    }
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
