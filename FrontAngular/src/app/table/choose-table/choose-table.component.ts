import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-choose-table',
  templateUrl: './choose-table.component.html',
  styleUrls: ['./choose-table.component.scss']
})
export class ChooseTableComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToDynamicTable(nu: number){
    if(nu == 1){
      this.router.navigate(["OneElement"]);
    }
    if(nu == 1000){
      this.router.navigate(["OneThousandElement"]);
    }
    if(nu == 10000){
      this.router.navigate(["TenThousandElement"]);
    }
    if(nu == 1000000){
      this.router.navigate(["MilionElement"]);
    }
  }
}
