import { Component, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NewsComponent } from 'src/app/pages/news/news/news.component';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor( ) { }

  ngOnInit() {
  }

}
