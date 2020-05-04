import { Routes, RouterModule } from '@angular/router';
import { TableComponent } from './table.component';
import { NgModule } from '@angular/core';
import { StaticTableComponent } from './static-table/static-table.component';
import { DynamicTableComponent } from './dynamic-table/dynamic-table.component';
import { ChooseTableComponent } from './choose-table/choose-table.component';

const routes: Routes = [
    {
      path: 'tableChoose',
      component: TableComponent,
    },
    { path: 'staticTable', component: StaticTableComponent },
    { path: 'dynamicTable', component: DynamicTableComponent },
    {path:'chooseTable',component:ChooseTableComponent}
  ];
  
  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
  })
  export class TableRoutingModule {}