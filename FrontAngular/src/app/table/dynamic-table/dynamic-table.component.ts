import { Component, OnInit, AfterViewInit, AfterContentChecked } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataModel } from 'src/app/shared/models/data.model';

@Component({
  selector: 'app-dynamic-table',
  templateUrl: './dynamic-table.component.html',
  styleUrls: ['./dynamic-table.component.scss'],
})
export class DynamicTableComponent implements OnInit,AfterContentChecked {
  private jsonURL = 'assets/jsonDataTable.json';
  public data: any = [];

  constructor(private router: Router, private http: HttpClient) {}
  ngAfterContentChecked(): void {
    console.warn('After content checked: ' + new Date().getTime());
  }

  ngOnInit(): void {
    console.warn(new Date().getTime());
    this.http.get(this.jsonURL).subscribe(result => {
      this.data = result;
    });
  }
}
