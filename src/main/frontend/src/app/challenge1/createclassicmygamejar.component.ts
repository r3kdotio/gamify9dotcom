import { BaseChallengeComponent } from '../shared/basechallenge.component';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';

import { Challenge1Service } from './challenge1.service';

@Component({
  template: `
<div class="animated fadeIn">
    <div class="card">
        <div class="card">
            <div class="card-header">
                create com.gamify9.mygame/com/gamify9/mygame/MyGame.java
            </div>
            <div class="card-body">
                <prism-hack-block [code]="classicGame" [language]="'java'"></prism-hack-block>
            </div>
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
        <div class="card">
            <div class="card-header">
                challenge
            </div>
            <div class="card-body">
                <prism-hack-block [code]="challenge" [language]="'java'"></prism-hack-block>
            </div>
        </div>


        

        <div>
            <textarea #input class="form-control" rows="3"></textarea>
            <button (click)="submit(input.value)" class="btn btn-primary">Submit</button>
        </div>
    <button (click)="next()" *ngIf="success" type="button" class="btn btn-success">Success, next challenge</button>
    <div *ngIf="errorMessage" class="alert alert-danger">
      <strong>Error!</strong>{{errorMessage}}
    </div>


 </div>
        `
})
export class CreateClassicMyGameJarComponent extends BaseChallengeComponent{

  compile = `javac -classpath oldstylejars/gameengine-1.0.0.jar com.gamify9.mygame/com/gamify9/mygame/MyGame.java -d oldstylejars/mygame/
jar -cvf  ./oldstylejars/mygame-1.0.0.jar -C oldstylejars/mygame com`;

  challenge = 'jar -d --file=oldstylejars/mygame-1.0.0.jar';

  classicGame =
  `package com.gamify9.mygame;

import com.gamify9.gameengine.*;

public class MyGame {
    public static void main(String[] args) throws Exception {
        GameEngine m = new GameEngine();
        m.loadSwingGUI();
        m.initGame();
        m.gameLoop();
    }
}`;

  constructor(private challenge1Service: Challenge1Service,private router: Router) {
    super();
  }

  submit(input) {
    console.info("Submit " + input);
    this.challenge1Service.createClassicMyGameJar(input).subscribe(res => this.evaluateResponse(res), error => { this.error(error) });
  }
  next() {
    this.router.navigate(['./challenge1/4']);
  }
}