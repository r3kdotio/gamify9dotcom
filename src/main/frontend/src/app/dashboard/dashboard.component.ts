import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service'
@Component({
  templateUrl : 'dashboard.component.html'
})
export class DashboardComponent {
  comments = [];

cssCode = 
`module com.gamify9.gameengine {
  exports com.gamify9.gameengine.api;
}
`;

  constructor(public auth: AuthService) {
    auth.handleAuthentication();
  }

  

}
