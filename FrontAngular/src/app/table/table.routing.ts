import { Routes, RouterModule } from '@angular/router';
import { TableComponent } from './table.component';
import { NgModule } from '@angular/core';
import { StaticTableComponent } from './static-table/static-table.component';
import { DynamicTableComponent } from './dynamic-table/dynamic-table.component';
import { ChooseTableComponent } from './choose-table/choose-table.component';
import { OneElementComponent } from './one-element/one-element.component';
import { MilionElementComponent } from './milion-element/milion-element.component';
import { TenThousandElementComponent } from './ten-thousand-element/ten-thousand-element.component';
import { OneThousandElementComponent } from './one-thousand-element/one-thousand-element.component';
import { CrudComponent } from './crud/crud.component';
import { ThreeKDataComponent } from './three-kdata/three-kdata.component';
import { FiveKDataComponent } from './five-kdata/five-kdata.component';
import { TwentyKDataComponent } from './twenty-kdata/twenty-kdata.component';
import { TenMDataComponent } from './ten-mdata/ten-mdata.component';
import { FiveMDataComponent } from './five-mdata/five-mdata.component';
import { ThreeMDataComponent } from './three-mdata/three-mdata.component';
import { FiftyKDataComponent } from './fifty-kdata/fifty-kdata.component';

const routes: Routes = [
    {
      path: 'tableChoose',
      component: TableComponent,
    },
    { path: 'staticTable', component: StaticTableComponent },
    { path: 'dynamicTable', component: DynamicTableComponent },
    {path:'chooseTable',component:ChooseTableComponent},
    {
      path:'OneElement',
      component: OneElementComponent,
    },
    {
      path:'OneThousandElement',
      component: OneThousandElementComponent,
    },
    {
      path:'ThreeKDataComponent',
      component: ThreeKDataComponent,
    },
    {
      path:'FiveKDataComponent',
      component: FiveKDataComponent,
    },
    {
      path:'TenThousandElement',
      component: TenThousandElementComponent,
    },
    {
      path:'TwentyKDataComponent',
      component: TwentyKDataComponent,
    },
    {
      path:'FiftyKDataComponent',
      component: FiftyKDataComponent,
    },
    {
      path:'MilionElement',
      component: MilionElementComponent,
    },
    {
      path:'ThreeMDataComponent',
      component: ThreeMDataComponent,
    },
    {
      path:'FiveMDataComponent',
      component: FiveMDataComponent,
    },
    {
      path:'TenMDataComponent',
      component: TenMDataComponent,
    },
    {
      path:'crud',
      component: CrudComponent,
    },
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
  })
  export class TableRoutingModule {}