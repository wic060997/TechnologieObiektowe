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
    if(nu == 3000){
      this.router.navigate(["ThreeKDataComponent"]);
    }
    if(nu == 5000){
      this.router.navigate(["FiveKDataComponent"]);
    }
    if(nu == 10000){
      this.router.navigate(["TenThousandElement"]);
    }
    if(nu == 20000){
      this.router.navigate(["TwentyKDataComponent"]);
    }
    if(nu == 50000){
      this.router.navigate(["FiftyKDataComponent"]);
    }
    if(nu == 1000000){
      this.router.navigate(["MilionElement"]);
    }
    if(nu == 3000000){
      this.router.navigate(["ThreeMDataComponent"]);
    }
    if(nu == 5000000){
      this.router.navigate(["FiveMDataComponent"]);
    }
    if(nu == 10000000){
      this.router.navigate(["TenMDataComponent"]);
    }
  }
}
