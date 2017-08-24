import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { MyCommonModule } from '../shared/mycommon.module';

@NgModule({
  imports: [
    MyCommonModule,
    DashboardRoutingModule
  ],
  declarations: [ DashboardComponent ]
})
export class DashboardModule { }
