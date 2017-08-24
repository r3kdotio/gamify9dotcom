import { BaseChallengeComponent } from '../shared/basechallenge.component';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { Response } from '@angular/http';
import { Challenge1Service } from './challenge1.service';


@Component({
  template: `
<div class="animated fadeIn">

    
      <div class="card">
        <div class="card-header">
          Challenge 1, setup Java 9 and create your hackathon envrionment
        </div>
        <div class="card-body">
          Download <a href="/3rdparty/jpct-1.jar" download="jpct-1.jar" target="_blank">jpct-1.jar</a> and place it in a directory on your computer.<br>
          You are not allowed to use an IDE and everything is on the command line.<br>
          After your envrionment is set up make sure Java 9 is in your PATH and execute the command below.
          <br><br>
          You will need to submit the result of the command to reach the next step.
        </div>
      </div>



        <div class="card">
            <div class="card-header">
                Sound check and create the challenge structure
            </div>
            <div class="card-body">
                <prism-hack-block [code]="createStructureBash" [language]="'java'"></prism-hack-block>
            </div>
            
            <div class="card-body">
                <prism-hack-block [code]="soundCheckJava9AndJpct" [language]="'java'"></prism-hack-block>
            </div>

        </div>
    <div>
        <textarea #input class="form-control" rows="3"></textarea>
        <button *ngIf="!successs" (click)="submit(input.value)" class="btn btn-primary">Submit</button>
    </div>
    
    <button *ngIf="successs" type="button" class="btn btn-success">Success</button>
    <div *ngIf="errorMessage" class="alert alert-danger">
      <strong>Error!</strong>{{errorMessage}}
    </div>


</div>`
})
export class ReadJavaVersionComponent extends BaseChallengeComponent {


  createStructureBash = `mkdir oldstylejars
mkdir 3rdparty
mkdir -p com.gamify9.gameengine/com/gamify9/gameengine/score/
mkdir -p com.gamify9.mygame/com/gamify9/mygame/

cp jpct-1.jar 3rdparty
`;
  soundCheckJava9AndJpct = 'jar -d --file=3rdparty/jpct-1.jar';


  constructor(private challenge1Service: Challenge1Service) {
    super();
  }

  submit(input) {
    console.info("submit " + input);
    this.challenge1Service.submitJavaVersion(input).subscribe(res => this.evaluateResponse(res), error => { this.error(error) });
  }

}
