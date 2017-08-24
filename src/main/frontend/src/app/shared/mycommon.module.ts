import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { CommonModule } from '@angular/common';
import { HttpModule } from '@angular/http';

/* Import prism core */
import 'prismjs/prism';
/* Import the language you need to highlight */
import 'prismjs/components/prism-typescript';
import 'prismjs/components/prism-java';
import { PrismHackComponent } from '../shared/prismhack.component';

@NgModule({
  imports: [
    ChartsModule,
    CommonModule,
    HttpModule
  ],
  declarations: [ PrismHackComponent ],
  exports: [PrismHackComponent, CommonModule, HttpModule]
})
export class MyCommonModule {}