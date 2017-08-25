import { BaseChallengeComponent } from '../shared/basechallenge.component';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge2Service } from './challenge2.service';

@Component({
  template: `
<div class="animated fadeIn">
        <div class="card">
        <div class="card-header"> 
        Now let's compile with a empty module-info.java. It's virtually empty, we just export the package com.gamify9.gameengine and not com.gamify9.gameengine.score to stop people 'hacking' our code.<br/>
        You will still get an error.<br/>
        Create the file com.gamify9.gameengine/module-info.java
            </div>
            <div class="card-body">
                <prism-hack-block [code]="moduleinfo" [language]="'java'"></prism-hack-block>
            </div>
        </div>
        <div class="card">
            <div class="card-header">
                compile
            </div>
            <div class="card-body">
                <prism-hack-block [code]="compile" [language]="'java'"></prism-hack-block>
            </div>
        </div>


    <div>
        <textarea #input class="form-control" rows="6"></textarea>
        <button *ngIf="!successs" (click)="submit(input.value)" class="btn btn-primary">Submit</button>
    </div>
    
    <button (click)="next()" *ngIf="successs" type="button" class="btn btn-success">Success, next challenge</button>
    <div *ngIf="errorMessage" class="alert alert-danger">
      <strong>Error!</strong>{{errorMessage}}
    </div>

 </div>`
})
export class GameEngineEmptyModuleComponent extends BaseChallengeComponent {
  
  moduleinfo =
`module com.gamify9.gameengine {

  exports com.gamify9.gameengine;


}`

  compile = 'javac --module-path 3rdparty/jpct-1.jar com.gamify9.gameengine/com/gamify9/gameengine/score/GameScore.java com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java com.gamify9.gameengine/module-info.java  -d mods/com.gamify9.gameengine'
  
  constructor(private challenge1Service: Challenge2Service,private router: Router) {
   super();
  }

  submit(input){
    console.info("Submit "+input);
    this.challenge1Service.withEmptyModuleInfo(input).subscribe(res => this.evaluateResponse(res), error => { this.error(error) });
  }
  next() {
    this.router.navigate(['./challenge2/3']);
  }
}