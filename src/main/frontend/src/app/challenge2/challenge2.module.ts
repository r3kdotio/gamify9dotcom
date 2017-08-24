import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { CommonModule } from '@angular/common';

import { MyCommonModule } from '../shared/mycommon.module';


import { Challenge2RoutingModule } from './challenge2-routing.module';
import { Challenge2Service } from './challenge2.service';
import { Challenge2Component } from './challenge2.component';

import { GameEngineDesktopComponent } from './gameenginedesktop.component';
import { CompileWithModuleDirComponent } from './compilewithmoduledir.component';
import { CompileWithoutModuleDirComponent } from './compilewithoutmoduledir.component';
import { GameEngineWithoutModuleInfoComponent } from './gameenginewithoutmoduleinfo.component';
import { GameEngineEmptyModuleComponent } from './gameengineemptymodule.component';


@NgModule({
  imports: [
    Challenge2RoutingModule,
    MyCommonModule
  ],
  declarations: [
    Challenge2Component,
    GameEngineDesktopComponent,
    CompileWithModuleDirComponent,
    CompileWithoutModuleDirComponent,
    GameEngineWithoutModuleInfoComponent,
    GameEngineEmptyModuleComponent
  ],
  providers: [
    Challenge2Service
  ]

})
export class Challenge2Module { }
