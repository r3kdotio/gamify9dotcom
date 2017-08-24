import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge2Service } from './challenge2.service';

@Component({
  template: `
<div class="animated fadeIn">
    CHALLENGE2
</div>`
})
export class Challenge2Component {
  constructor(private challenge2Service: Challenge2Service) {
   
  }

}