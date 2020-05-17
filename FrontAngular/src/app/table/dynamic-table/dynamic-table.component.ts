import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataModel } from 'src/app/shared/models/data.model';

@Component({
  selector: 'app-dynamic-table',
  templateUrl: './dynamic-table.component.html',
  styleUrls: ['./dynamic-table.component.scss'],
})
export class DynamicTableComponent  {
  private jsonURL = 'assets/jsonDataTable.json';
  public data: any = [];

  constructor(private router: Router, private http: HttpClient) {}
  ngAfterViewInit(): void {
    console.log(new Date().getTime());
  }

  ngOnInit(): void {
    console.log(new Date().getTime());
    this.http.get(this.jsonURL).subscribe(result => {
      this.data = result;
    });
  }
}
