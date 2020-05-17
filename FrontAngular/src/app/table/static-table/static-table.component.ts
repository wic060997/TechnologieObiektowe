import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-static-table',
  templateUrl: './static-table.component.html',
  styleUrls: ['./static-table.component.scss']
})
export class StaticTableComponent implements OnInit,AfterViewInit {
  private jsonURL = 'assets/jsonDataTable.json';
  public data: any = [];

  constructor(private router: Router, private http: HttpClient) {}
  ngAfterViewInit(): void {
    console.warn('END TIME: ' +new Date().getTime());
  }

  ngOnInit(): void {
    this.http.get(this.jsonURL).subscribe(result => {
      this.data = result;
      console.warn('START TIME: ' +new Date().getTime());
    });
  }
}
