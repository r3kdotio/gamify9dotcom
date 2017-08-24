import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge1Service } from './challenge1.service';

@Component({
  template: `
<div class="animated fadeIn">
    CHALLENGE1
</div>`
})
export class Challenge1Component {
  constructor(private challenge1Service: Challenge1Service) {
   
  }

  submitJavaVersion(input){
    console.info("Submit java version "+input);
    this.challenge1Service.submitJavaVersion(input).subscribe(res => console.log(res));;
  }

}