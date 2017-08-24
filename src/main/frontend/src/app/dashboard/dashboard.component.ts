import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service'
@Component({
  template: `
<div class="animated fadeIn">
    <div>
        <prism-hack-block [code]="cssCode" [language]="'java'"></prism-hack-block>
    </div>
</div>`
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
