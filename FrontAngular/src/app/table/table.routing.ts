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
      path:'TenThousandElement',
      component: TenThousandElementComponent,
    },
    {
      path:'MilionElement',
      component: MilionElementComponent,
    },
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
  })
  export class TableRoutingModule {}