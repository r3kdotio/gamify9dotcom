import { NgModule } from '@angular/core';
import {
  Routes,
  RouterModule
} from '@angular/router';

import { GameEngineDesktopJPCTComponent } from './gameenginedesktopjpct.component'; 
import { GameEngineDesktopComponent } from './gameenginedesktop.component';
import { CompileWithModuleDirComponent } from './compilewithmoduledir.component';
import { CompileWithoutModuleDirComponent } from './compilewithoutmoduledir.component';
import { GameEngineWithoutModuleInfoComponent } from './gameenginewithoutmoduleinfo.component';
import { GameEngineEmptyModuleComponent } from './gameengineemptymodule.component';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Challenge 2'
    },
    children: [
      {
        path: '3',
        component: GameEngineDesktopComponent,
        data: {
          title: '3 Game Engine Desktop'
        }
      },
      {
        path: '4',
        component: GameEngineDesktopJPCTComponent,
        data: {
          title: '4 Compile With Module Dir'
        }
      },
      {
        path: '5',
        component: CompileWithModuleDirComponent,
        data: {
          title: '5 Compile With Module Dir'
        }
      },
      {
        path: '6',
        component: CompileWithoutModuleDirComponent,
        data: {
          title: '6 Compile Without Module Dir'
        }
      },
      {
        path: '1',
        component: GameEngineWithoutModuleInfoComponent,
        data: {
          title: '1 Game Engine Without Module Info'
        }
      },
      {
        path: '2',
        component: GameEngineEmptyModuleComponent,
        data: {
          title: '2 Game Engine Empty Module'
        }
      }
    ]
  }]


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Challenge2RoutingModule { }
