import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  constructor(private router: Router) {
    
   }

  ngOnInit(): void {
  }

  goToTextChoose(){
    this.router.navigate(["staticText"]);
  }

  goToTableChoose(){
    this.router.navigate(["tableChoose"]);
  }
}
