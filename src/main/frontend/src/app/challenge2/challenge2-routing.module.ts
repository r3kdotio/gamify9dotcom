import { NgModule } from '@angular/core';
import {
  Routes,
  RouterModule
} from '@angular/router';


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
        path: '5',
        component: GameEngineDesktopComponent,
        data: {
          title: '5 Game Engine Desktop'
        }
      },
      {
        path: '4',
        component: CompileWithModuleDirComponent,
        data: {
          title: '4 Compile With Module Dir'
        }
      },
      {
        path: '3',
        component: CompileWithoutModuleDirComponent,
        data: {
          title: '3 Compile Without Module Dir'
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
