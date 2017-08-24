import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge2Service } from './challenge2.service';

@Component({
  template: `
<div class="animated fadeIn">
        <div class="card">
            <div class="card-header">
                module-info
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
            <textarea #input class="form-control" rows="3"></textarea>
            <button (click)="submit(input.value)" class="btn btn-primary">Submit</button>
        </div>
 </div>`
})
export class GameEngineEmptyModuleComponent {
  
  moduleinfo =
`module com.gamify9.gameengine {

  exports com.gamify9.gameengine;


}`

  compile = 'javac --module-path 3rdparty/jpct-1.jar:3rdparty/lwjglutil-2.9.3.jar com.gamify9.gameengine/com/gamify9/gameengine/score/GameScore.java com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java com.gamify9.gameengine/module-info.java  -d mods/com.gamify9.gameengine'
  
  constructor(private challenge1Service: Challenge2Service) {
   
  }

  submit(input){
    console.info("Submit "+input);
    this.challenge1Service.withEmptyModuleInfo(input).subscribe(res => console.log(res));;
  }

}