import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DataModel } from 'src/app/shared/models/data.model';

@Component({
  selector: 'app-dynamic-table',
  templateUrl: './dynamic-table.component.html',
  styleUrls: ['./dynamic-table.component.scss'],
})
export class DynamicTableComponent implements OnInit {
  private jsonURL = 'assets/jsonDataTable.json';
  protected data: DataModel[];

  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get(this.jsonURL).subscribe((data) => {
      console.log(data);
    });
  }
}
