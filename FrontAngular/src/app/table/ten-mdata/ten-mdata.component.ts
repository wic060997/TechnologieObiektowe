import { Component, OnInit, AfterContentChecked } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataService } from 'src/app/shared/DataService';
@Component({
  selector: 'app-ten-mdata',
  templateUrl: './ten-mdata.component.html',
  styleUrls: ['./ten-mdata.component.scss']
})
export class TenMDataComponent implements OnInit, AfterContentChecked {
  public data: any;

  constructor(private router: Router, private http: HttpClient,private service: DataService ) {}

  ngAfterContentChecked(): void {
    console.warn('After content checked: ' + new Date().getTime());
  }

  ngOnInit(): void {
    console.warn('START TIME: ' +new Date().getTime());
    this.service.getTenMilionElement().subscribe(data=>{
      this.data = data;
      
    })
  }
}
