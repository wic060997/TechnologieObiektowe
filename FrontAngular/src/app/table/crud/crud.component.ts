import { Component, OnInit, AfterContentChecked } from '@angular/core';
import {  User } from 'src/app/shared/models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.scss'],
})
export class CrudComponent implements OnInit,AfterContentChecked {
  public list: User[]= [];
  protected newUser: User;
  protected index;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    console.warn("Init start: "+new Date().getTime())
  }

  ngAfterContentChecked(): void {
    console.warn('After content checked: ' + new Date().getTime());
  }

  public add($event,name: string,surname: string){
    console.warn('add or edit time: ' + new Date().getTime());
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
    console.warn('remove time: ' + new Date().getTime());
    this.list.splice(index,1);
  }

  public edit(index: number){
    let date = this.list[index];
    this.newUser.name= date.name;
    this.newUser.surname = date.surname;
    this.index = index;
  }
}
