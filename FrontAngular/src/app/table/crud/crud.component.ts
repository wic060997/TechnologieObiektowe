import { Component, OnInit } from '@angular/core';
import {  User } from 'src/app/shared/models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.scss'],
})
export class CrudComponent implements OnInit {
  public list: User[]= [];
  protected newUser: User;
  protected index;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    
  }

  public add($event,name: string,surname: string){
    event.stopPropagation();
    event.preventDefault();
    this.newUser = new User;
    this.newUser.name = name;
    this.newUser.surname = surname;
    if(this.index == null){
      
    this.list.push(this.newUser);
    } else{
      this.list[this.index] = this.newUser;
    }
    this.index = null;
    this.newUser = new User();
  }

  public remove(index: number){
    this.list.splice(index,1);
  }

  public edit(index: number){
    let date = this.list[index];
    this.newUser.name= date.name;
    this.newUser.surname = date.surname;
    this.index = index;
  }
}
