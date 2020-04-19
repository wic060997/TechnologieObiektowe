import { Routes, RouterModule } from '@angular/router';
import { TextComponent } from './text.component';
import { NgModule } from '@angular/core';
import { StaticTextComponent } from './static-text/static-text.component';
import { DynamicTextComponent } from './dynamic-text/dynamic-text.component';

const routes: Routes = [
  {
    path: 'textChoose',
    component: TextComponent,
  },
  { path: 'staticText', component: StaticTextComponent },
  { path: 'dynamicText', component: DynamicTextComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class TextRoutingModule {}
