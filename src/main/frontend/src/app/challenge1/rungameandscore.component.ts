import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge1Service } from './challenge1.service';

@Component({
  template: `
<div class="animated fadeIn">
        <div class="card">
            <div class="card-header">
                Run the game and score a point!
            </div>
            <div class="card-body">
                <prism-hack-block [code]="runGame" [language]="'java'"></prism-hack-block>
            </div>
        </div>
        <div>
            <textarea #input class="form-control" rows="3"></textarea>
            <button (click)="submit(input.value)" class="btn btn-primary">Submit</button>
        </div>
 </div>`
})
export class RunGameAndScoreComponent {
  
  runGame = 'java -classpath 3rdparty/jpct-1.jar:oldstylejars/gameengine-1.0.0.jar:oldstylejars/mygame-1.0.0.jar com.gamify9.mygame.MyGame'
  
  constructor(private challenge1Service: Challenge1Service) {
   
  }

  submit(input){
    console.info("Submit "+input);
    this.challenge1Service.runGameAndScore(input).subscribe(res => console.log(res));;
  }

}