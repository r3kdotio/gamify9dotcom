import { NgModule } from '@angular/core';
import {
  Routes,
  RouterModule
} from '@angular/router';

import { Challenge1Component } from './challenge1.component';
import { ReadJavaVersionComponent } from './readjavaversion.component';
import { RunGameAndScoreComponent } from './rungameandscore.component';
import { RunGameandScore2000PointsComponent } from './rungameandscore2000points.component';
import { CreateClassicMyGameJarComponent } from './createclassicmygamejar.component';
import { CreateClassicGameEngineJarComponent } from './createclassicgameenginejar.component';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Challenge 1'
    },
    children: [
      {
        path: '1',
        component: ReadJavaVersionComponent,
        data: {
          title: '1 Check Java Version'
        }
      },
      {
        path: '4',
        component: RunGameAndScoreComponent,
        data: {
          title: '4 Run Game And Score'
        }
      },
      {
        path: '5',
        component: RunGameandScore2000PointsComponent,
        data: {
          title: '5 Run Game and Score 2000 Points'
        }
      },
      {
        path: '3',
        component: CreateClassicMyGameJarComponent,
        data: {
          title: '3 Create Classic My Game Jar'
        }
      },
      {
        path: '2',
        component: CreateClassicGameEngineJarComponent,
        data: {
          title: '2 Create Classic Game Engine Jar'
        }
      }
    ]
  }]
  

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class Challenge1RoutingModule { }
