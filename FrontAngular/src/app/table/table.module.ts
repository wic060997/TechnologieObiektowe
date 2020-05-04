import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableComponent } from './table.component';
import { StaticTableComponent } from './static-table/static-table.component';
import { DynamicTableComponent } from './dynamic-table/dynamic-table.component';
import { TableRoutingModule } from './table.routing';
import { ChooseTableComponent } from './choose-table/choose-table.component';

@NgModule({
  declarations: [TableComponent, StaticTableComponent, DynamicTableComponent, ChooseTableComponent],
  imports: [CommonModule, TableRoutingModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
})
export class TableModule {}
