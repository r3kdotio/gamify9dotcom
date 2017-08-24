import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge2Service } from './challenge2.service';

@Component({
  template: `
<div class="animated fadeIn">
        <div class="card">
            <div class="card-header">
                compile
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
export class CompileWithoutModuleDirComponent {
  
  runGame = 'java -classpath 3rdparty/jpct-1.jar:3rdparty/lwjgl_util-2.9.3.jar:oldstylejars/gameengine-1.0.0.jar:oldstylejars/mygame-1.0.0.jar com.gamify9.mygame.MyGame'
  
  constructor(private challenge1Service: Challenge2Service) {
   
  }

  submit(input){
    console.info("Submit "+input);
    this.challenge1Service.compileWithoutModuleDir(input).subscribe(res => console.log(res));;
  }

}