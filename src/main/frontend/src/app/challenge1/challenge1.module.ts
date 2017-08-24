import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { CommonModule } from '@angular/common';

import { MyCommonModule } from '../shared/mycommon.module';


import { Challenge1RoutingModule } from './challenge1-routing.module';
import { Challenge1Service } from './challenge1.service';

import { ReadJavaVersionComponent } from './readjavaversion.component';
import { RunGameAndScoreComponent } from './rungameandscore.component';
import { RunGameandScore2000PointsComponent } from './rungameandscore2000points.component';
import { CreateClassicMyGameJarComponent } from './createclassicmygamejar.component';
import { CreateClassicGameEngineJarComponent } from './createclassicgameenginejar.component';
import { Challenge1Component } from './challenge1.component';


@NgModule({
  imports: [
    Challenge1RoutingModule,
    MyCommonModule
  ],
  declarations: [
    Challenge1Component,
    ReadJavaVersionComponent,
    RunGameAndScoreComponent,
    RunGameandScore2000PointsComponent,
    CreateClassicMyGameJarComponent,
    CreateClassicGameEngineJarComponent
  ],
  providers: [
    Challenge1Service
  ]

})
export class Challenge1Module { }
