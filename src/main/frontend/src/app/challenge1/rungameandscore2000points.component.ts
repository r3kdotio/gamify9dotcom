import { BaseChallengeComponent } from '../shared/basechallenge.component';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge1Service } from './challenge1.service';

@Component({
  template: `
<div class="animated fadeIn">

Now "Hack" the gameengine by getting and instance of the GameScore (GameScore.getInstance()) from MyGame.java 

This demonstrates unintended access to library class

        <div>
            <textarea #input class="form-control" rows="3"></textarea>
            <button (click)="submit(input.value)" class="btn btn-primary">Submit</button>
        </div>

    <button *ngIf="successs" type="button" class="btn btn-success">Success</button>
    <div *ngIf="errorMessage" class="alert alert-danger">
      <strong>Error!</strong>{{errorMessage}}
    </div>

 </div>`
})
export class RunGameandScore2000PointsComponent extends BaseChallengeComponent{
  
   
  runGame = 'java -classpath 3rdparty/jpct-1.jar:oldstylejars/gameengine-1.0.0.jar:oldstylejars/mygame-1.0.0.jar com.gamify9.mygame.MyGame'

  
  constructor(private challenge1Service: Challenge1Service,private router: Router) {
   super();
  }

  submit(input){
    console.info("Submit "+input);
    this.challenge1Service.runGameAndScore2000Points(input).subscribe(res => this.evaluateResponse(res), error => { this.error(error) });
  }

  next() {
    this.router.navigate(['./challenge2/1']);
  }

}