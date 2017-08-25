import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service'
@Component({
  templateUrl : 'dashboard.component.html'
})
export class DashboardComponent {



  constructor(public auth: AuthService,private router: Router) {

  }
  go() {
    this.router.navigate(['./challenge1/1']);
  }
  

}
