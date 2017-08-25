import { Response } from '@angular/http';

export class BaseChallengeComponent {
    //null means not attemped, true means success, false means failure
    successs : Boolean;
    errorMessage = null;

    evaluateResponse(res: Response) {
        console.info("Success");
        this.successs = true;
        this.errorMessage = null;
    }

    error(error) {
        console.info("Error " + error.json().message);
        this.errorMessage = error.json().message;
        this.successs = false;
    }
}