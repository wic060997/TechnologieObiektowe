import { Component, OnInit, AfterViewInit, AfterContentChecked } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataService } from 'src/app/shared/DataService';

@Component({
  selector: 'app-milion-element',
  templateUrl: './milion-element.component.html',
  styleUrls: ['./milion-element.component.scss']
})
export class MilionElementComponent implements OnInit,AfterContentChecked {

  public data: any;

  constructor(private router: Router, private http: HttpClient,private service: DataService) {}

  ngAfterContentChecked(): void {
    console.warn('After content checked: ' + new Date().getTime());
  }

  ngOnInit(): void {
    console.warn('START TIME: ' +new Date().getTime());
    this.service.getOneMilionElement().subscribe(response => {
      this.data = response;
      //console.log('START TIME: ' +new Date().getTime());
    })
  }
}

