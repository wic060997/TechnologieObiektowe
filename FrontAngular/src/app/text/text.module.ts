import { NgModule, NO_ERRORS_SCHEMA, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TextComponent } from './text.component';
import { TextRoutingModule } from './text.routing';
import { StaticTextComponent } from './static-text/static-text.component';
import { DynamicTextComponent } from './dynamic-text/dynamic-text.component';



@NgModule({
  declarations: [TextComponent, StaticTextComponent, DynamicTextComponent],
  imports: [
    CommonModule,
    TextRoutingModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
})
export class TextModule { }
