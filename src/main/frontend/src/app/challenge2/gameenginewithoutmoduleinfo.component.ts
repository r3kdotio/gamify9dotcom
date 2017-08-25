import { BaseChallengeComponent } from '../shared/basechallenge.component';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge2Service } from './challenge2.service';

@Component({
  template: `
    <div class="animated fadeIn">
      <div class="card-header">
      Create the challenge structure for modules
      </div>
      <div class="card-body">
        For this challenge, we use the --module-path and not the -classpath.<br/>
        When this is used it automatically brings new problems like in this case below. We compile without a module-info.java
        <prism-hack-block [code]="createStructureBash" [language]="'java'"></prism-hack-block>
      </div>

        <div class="card">
            <div class="card-header">
                compile
            </div>
            <div class="card-body">
                <prism-hack-block [code]="runGame" [language]="'java'"></prism-hack-block>
            </div>
        </div>
        <div>
    <div>
        <textarea #input class="form-control" rows="3"></textarea>
        <button *ngIf="!success" (click)="submit(input.value)" class="btn btn-primary">Submit</button>
    </div>
    
    <button (click)="next()" *ngIf="success" type="button" class="btn btn-success">Success, next challenge</button>
    <div *ngIf="errorMessage" class="alert alert-danger">
      <strong>Error!</strong>{{errorMessage}}
    </div>
 </div>`
})
export class GameEngineWithoutModuleInfoComponent extends BaseChallengeComponent{
  
  createStructureBash = `mkdir mods`;

  runGame = 'javac -verbose  --module-path 3rdparty/jpct-1.jar com.gamify9.gameengine/com/gamify9/gameengine/score/GameScore.java com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java -d mods/com.gamify9.gameengine'
  
  constructor(private challenge2Service: Challenge2Service,private router: Router) {
   super();
  }

  submit(input){
    console.info("Submit "+input);
    this.challenge2Service.compileWithoutModuleDir(input).subscribe(res => this.evaluateResponse(res), error => { this.error(error) });
  }
  next() {
    this.router.navigate(['./challenge2/2']);
  }
}
