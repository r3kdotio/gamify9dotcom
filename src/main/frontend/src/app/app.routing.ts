import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CallbackComponent } from './callback/callback.component';

import { AuthenticationCallbackActivateGuard } from './shared/authentication-guard';

// Layouts
import { FullLayoutComponent } from './layouts/full-layout.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  },
  { path: 'callback', component: CallbackComponent },
  {
    path: '',
    component: FullLayoutComponent,
    canActivate: [AuthenticationCallbackActivateGuard],
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'dashboard',
        loadChildren: './dashboard/dashboard.module#DashboardModule'
      },
      {
        path: 'challenge1',
        loadChildren: './challenge1/challenge1.module#Challenge1Module'
      },
      {
        path: 'challenge2',
        loadChildren: './challenge2/challenge2.module#Challenge2Module'
      },
    ]
  }, { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
