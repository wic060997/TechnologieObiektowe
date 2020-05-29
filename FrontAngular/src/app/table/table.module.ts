import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableComponent } from './table.component';
import { StaticTableComponent } from './static-table/static-table.component';
import { DynamicTableComponent } from './dynamic-table/dynamic-table.component';
import { TableRoutingModule } from './table.routing';
import { ChooseTableComponent } from './choose-table/choose-table.component';
import { OneElementComponent } from './one-element/one-element.component';
import { OneThousandElementComponent } from './one-thousand-element/one-thousand-element.component';
import { TenThousandElementComponent } from './ten-thousand-element/ten-thousand-element.component';
import { MilionElementComponent } from './milion-element/milion-element.component';
import { CrudComponent } from './crud/crud.component';
import { ThreeKDataComponent } from './three-kdata/three-kdata.component';
import { FiveKDataComponent } from './five-kdata/five-kdata.component';
import { TwentyKDataComponent } from './twenty-kdata/twenty-kdata.component';
import { FiftyKDataComponent } from './fifty-kdata/fifty-kdata.component';
import { ThreeMDataComponent } from './three-mdata/three-mdata.component';
import { FiveMDataComponent } from './five-mdata/five-mdata.component';
import { TenMDataComponent } from './ten-mdata/ten-mdata.component';

@NgModule({
  declarations: [TableComponent, StaticTableComponent, DynamicTableComponent, ChooseTableComponent, OneElementComponent, OneThousandElementComponent, TenThousandElementComponent, MilionElementComponent, CrudComponent, ThreeKDataComponent, FiveKDataComponent, TwentyKDataComponent, FiftyKDataComponent, ThreeMDataComponent, FiveMDataComponent, TenMDataComponent],
  imports: [CommonModule, TableRoutingModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
})
export class TableModule {}
