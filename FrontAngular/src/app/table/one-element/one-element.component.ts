import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataService } from 'src/app/shared/DataService';

@Component({
  selector: 'app-one-element',
  templateUrl: './one-element.component.html',
  styleUrls: ['./one-element.component.scss']
})
export class OneElementComponent implements OnInit,AfterViewInit {
  public data: any;

  constructor(private router:Router, private http:HttpClient,private service: DataService) { }

  ngAfterViewInit(): void {
    console.warn('END TIME: ' +new Date().getTime());
  }

  ngOnInit(): void {
    console.warn('START TIME: ' +new Date().getTime());
    this.service.getOneElement().subscribe(data=>{
      this.data = data;
      //console.log('START TIME: ' +new Date().getTime());
    })
  }


}
