import { Component, OnInit, AfterViewInit, AfterContentChecked } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataService } from 'src/app/shared/DataService';

@Component({
  selector: 'app-ten-thousand-element',
  templateUrl: './ten-thousand-element.component.html',
  styleUrls: ['./ten-thousand-element.component.scss'],
})
export class TenThousandElementComponent implements OnInit, AfterContentChecked {
  public data: any

  constructor(private router: Router, private http: HttpClient,private service: DataService) {}

  ngAfterContentChecked(): void {
    console.warn('After content checked: ' + new Date().getTime());
  }

  ngOnInit(): void {
    console.warn('START TIME: ' +new Date().getTime());
    this.service.getTenThousendElement().subscribe(data=>{
      this.data = data;
      //console.log('START TIME: ' +new Date().getTime());
    })
  }
}
